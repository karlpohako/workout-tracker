package ee.karl.workouttracker.service.workoutexercise;

import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseCreationDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseInfo;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseUpdateDto;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.exercise.Exercise;
import ee.karl.workouttracker.presistence.exercise.ExerciseRepository;
import ee.karl.workouttracker.presistence.exerciseset.ExerciseSetRepository;
import ee.karl.workouttracker.presistence.workout.Workout;
import ee.karl.workouttracker.presistence.workout.WorkoutRepository;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExercise;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExerciseMapper;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExerciseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkoutExerciseService {

    private final WorkoutExerciseMapper workoutExerciseMapper;
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;
    private final ExerciseSetRepository exerciseSetRepository;

    @Transactional
    public void saveWorkoutExercise(Integer workoutId, WorkoutExerciseCreationDto workoutExerciseCreationDto) {
        WorkoutExercise workoutExercise = createWorkoutExercise(workoutId, workoutExerciseCreationDto);
        workoutExerciseRepository.save(workoutExercise);

    }

    public List<WorkoutExerciseInfo> findAllWorkoutExercises() {
        return workoutExerciseMapper.toInfoDtos(workoutExerciseRepository.findAll());
    }

    public WorkoutExerciseDto findWorkoutExercise(Integer workoutExerciseId) {
        WorkoutExercise workoutExercise = getWorkoutExercise(workoutExerciseId);
        return workoutExerciseMapper.toDto(workoutExercise);
    }

    @Transactional
    public void updateWorkoutExercise(Integer workoutExerciseId, WorkoutExerciseUpdateDto workoutExerciseDto) {
        doesWorkoutExerciseExist(workoutExerciseId);
        WorkoutExercise workoutExercise = adjustOrderIndexOnUpdate(workoutExerciseId, workoutExerciseDto.getOrderIndex());

        workoutExerciseMapper.updateDtoToEntity(workoutExerciseDto, workoutExercise);
        updateExerciseIfChanged(workoutExerciseDto, workoutExercise);

        workoutExerciseRepository.save(workoutExercise);

    }

    @Transactional
    public void deleteWorkoutExercise(Integer workoutExerciseId) {
        doesWorkoutExerciseExist(workoutExerciseId);
        workoutExerciseRepository.deleteById(workoutExerciseId);
    }

    private void doesWorkoutExerciseExist(Integer workoutExerciseId) {
        if (!workoutExerciseRepository.existsById(workoutExerciseId)) {
            throw new DataNotFoundException(Error.WORKOUTEXERCISE_NOT_FOUND.getMessage());
        }
    }

    private void updateExerciseIfChanged(WorkoutExerciseUpdateDto workoutExerciseDto, WorkoutExercise workoutExercise) {
        boolean exerciseStaysSame = workoutExercise.getExercise().getId().equals(workoutExerciseDto.getExerciseId());
        if (!exerciseStaysSame) {
            exerciseSetRepository.deleteAllByWorkoutExerciseId(workoutExercise.getId());
            Exercise exercise = getExercise(workoutExerciseDto.getExerciseId());
            workoutExercise.setExercise(exercise);
        }
    }

    private WorkoutExercise adjustOrderIndexOnUpdate(Integer workoutExerciseId, Integer requestedOrderIndex) {
        WorkoutExercise workoutExercise = getWorkoutExercise(workoutExerciseId);
        Integer currentOrderIndex = workoutExercise.getOrderIndex();
        Integer workoutId = workoutExercise.getWorkout().getId();

        Integer maxOrderIndex = workoutExerciseRepository.findWorkOutExerciseMaxOrderIndex(workoutId);
        Integer targetOrderIndex = Math.max(1, Math.min(requestedOrderIndex, maxOrderIndex));

        if (currentOrderIndex.equals(targetOrderIndex)) {
            return workoutExercise;
        }

        shiftExercisesForReordering(workoutId, currentOrderIndex, targetOrderIndex);

        workoutExercise.setOrderIndex(targetOrderIndex);
        return workoutExercise;
    }

    private void shiftExercisesForReordering(Integer workoutId, Integer currentOrderIndex, Integer targetOrderIndex) {
        if (targetOrderIndex > currentOrderIndex) {
            // Moving exercise from position 2 to 5: shift exercises 3,4,5 down to 2,3,4
            workoutExerciseRepository.decrementOrderIndexInRange(workoutId, currentOrderIndex, targetOrderIndex);
        } else {
            // Moving exercise from position 5 to 2: shift exercises 2,3,4 up to 3,4,5
            workoutExerciseRepository.incrementOrderIndexInRange(workoutId, targetOrderIndex, currentOrderIndex);
        }
    }

    private WorkoutExercise createWorkoutExercise(Integer workoutId, WorkoutExerciseCreationDto workoutExerciseCreationDto) {
        Workout workout = getWorkout(workoutId);
        Exercise exercise = getExercise(workoutExerciseCreationDto.getExerciseId());

        Integer adjustedOrderIndex = adjustOrderIndexOnCreation(workoutId, workoutExerciseCreationDto.getOrderIndex());

        workoutExerciseRepository.shiftOrderIndexesOnCreation(workoutId, adjustedOrderIndex);

        WorkoutExercise workoutExercise = workoutExerciseMapper.creationToEntity(workoutExerciseCreationDto);

        workoutExercise.setWorkout(workout);
        workoutExercise.setExercise(exercise);
        workoutExercise.setOrderIndex(adjustedOrderIndex);

        return workoutExercise;
    }

    private Integer adjustOrderIndexOnCreation(Integer workoutId, Integer requestOrderIndex) {
        Integer maxIndex = workoutExerciseRepository.findWorkOutExerciseMaxOrderIndex(workoutId);

        if (maxIndex != null && requestOrderIndex > maxIndex + 1) {
            requestOrderIndex = maxIndex + 1;
        } else if (maxIndex == null) {
            requestOrderIndex = 1;
        }

        return requestOrderIndex;
    }

    private Exercise getExercise(Integer exerciseId) {
        return exerciseRepository.findById(exerciseId).orElseThrow(
                () -> new DataNotFoundException(Error.EXERCISE_NOT_FOUND.getMessage())
        );
    }

    private Workout getWorkout(Integer workoutId) {
        return workoutRepository.findById(workoutId).orElseThrow(
                () -> new DataNotFoundException(Error.WORKOUT_NOT_FOUND.getMessage())
        );
    }

    private WorkoutExercise getWorkoutExercise(Integer workoutExerciseId) {
        return workoutExerciseRepository.findById(workoutExerciseId).orElseThrow(
                () -> new DataNotFoundException(Error.WORKOUTEXERCISE_NOT_FOUND.getMessage())
        );
    }
}
