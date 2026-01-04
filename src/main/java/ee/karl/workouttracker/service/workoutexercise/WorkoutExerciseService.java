package ee.karl.workouttracker.service.workoutexercise;

import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExercise;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExerciseMapper;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkoutExerciseService {

    private final WorkoutExerciseMapper workoutExerciseMapper;
    private final WorkoutExerciseRepository workoutExerciseRepository;

    public List<WorkoutExerciseInfo> findAllWorkoutExercises() {
        return workoutExerciseMapper.toInfoDtos(workoutExerciseRepository.findAll());
    }

    public WorkoutExerciseDto findWorkoutExercise(Integer workoutExerciseId) {
        WorkoutExercise workoutExercise = getWorkoutExercise(workoutExerciseId);
        return workoutExerciseMapper.toDto(workoutExercise);
    }

    private WorkoutExercise getWorkoutExercise(Integer workoutExerciseId) {
        return workoutExerciseRepository.findById(workoutExerciseId).orElseThrow(
                () -> new DataNotFoundException(Error.WORKOUTEXERCISE_NOT_FOUND.getMessage())
        );
    }
}
