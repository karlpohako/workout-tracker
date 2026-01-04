package ee.karl.workouttracker.service.workoutexercise;

import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseCreationDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.exercise.Exercise;
import ee.karl.workouttracker.presistence.exercise.ExerciseRepository;
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

    public List<WorkoutExerciseInfo> findAllWorkoutExercises() {
        return workoutExerciseMapper.toInfoDtos(workoutExerciseRepository.findAll());
    }

    public WorkoutExerciseDto findWorkoutExercise(Integer workoutExerciseId) {
        WorkoutExercise workoutExercise = getWorkoutExercise(workoutExerciseId);
        return workoutExerciseMapper.toDto(workoutExercise);
    }

    @Transactional
    public void saveWorkoutExercise(Integer workoutId, WorkoutExerciseCreationDto workoutExerciseCreationDto) {
        WorkoutExercise workoutExercise = createWorkoutExercise(workoutId, workoutExerciseCreationDto);
        workoutExerciseRepository.save(workoutExercise);

    }

    private WorkoutExercise createWorkoutExercise(Integer workoutId, WorkoutExerciseCreationDto workoutExerciseCreationDto) {
        Workout workout = getWorkout(workoutId);
        Exercise exercise = getExercise(workoutExerciseCreationDto);
        Integer adjustedOrderIndex = adjustOrderIndex(workoutId, workoutExerciseCreationDto);
        workoutExerciseRepository.shiftOrderIndexes(workoutId, adjustedOrderIndex);
        WorkoutExercise workoutExercise = workoutExerciseMapper.creationToEntity(workoutExerciseCreationDto);
        workoutExercise.setWorkout(workout);
        workoutExercise.setExercise(exercise);
        workoutExercise.setOrderIndex(adjustedOrderIndex);
        return workoutExercise;
    }

    private Integer adjustOrderIndex(Integer workoutId, WorkoutExerciseCreationDto workoutExerciseCreationDto) {
        Integer maxIndex = workoutExerciseRepository.findWorkOutExerciseMaxOrderIndex(workoutId);
        Integer requestOrderIndex = workoutExerciseCreationDto.getOrderIndex();

        if (maxIndex != null && requestOrderIndex > maxIndex + 1) {
            requestOrderIndex = maxIndex + 1;
        } else if (maxIndex == null) {
            requestOrderIndex = 1;
        }
        return requestOrderIndex;
    }

    private Exercise getExercise(WorkoutExerciseCreationDto workoutExerciseCreationDto) {
        return exerciseRepository.findById(workoutExerciseCreationDto.getExerciseId()).orElseThrow(
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
