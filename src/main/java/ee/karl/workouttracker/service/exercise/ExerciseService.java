package ee.karl.workouttracker.service.exercise;

import ee.karl.workouttracker.controller.exercise.dto.ExerciseDto;
import ee.karl.workouttracker.controller.exercise.dto.ExerciseInfoDto;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.exercise.Exercise;
import ee.karl.workouttracker.presistence.exercise.ExerciseMapper;
import ee.karl.workouttracker.presistence.exercise.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public ExerciseDto findExercise(Integer exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new DataNotFoundException(Error.EXERCISE_NOT_FOUND.getMessage()));
        return exerciseMapper.toExerciseDto(exercise);
    }

    public List<ExerciseInfoDto> findAllExercises() {
        return exerciseMapper.toExerciseInfoDtos(exerciseRepository.findAll());
    }
}
