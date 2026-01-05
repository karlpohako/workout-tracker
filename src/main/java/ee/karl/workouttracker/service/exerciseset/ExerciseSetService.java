package ee.karl.workouttracker.service.exerciseset;

import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetDto;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.exerciseset.ExerciseSet;
import ee.karl.workouttracker.presistence.exerciseset.ExerciseSetMapper;
import ee.karl.workouttracker.presistence.exerciseset.ExerciseSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseSetService {

    private final ExerciseSetRepository exerciseSetRepository;
    private final ExerciseSetMapper exerciseSetMapper;

    public ExerciseSetDto findExerciseSetById(Integer exerciseSetId) {
        ExerciseSet exerciseSet = getExerciseSet(exerciseSetId);
        return exerciseSetMapper.toDto(exerciseSet);
    }

    private ExerciseSet getExerciseSet(Integer exerciseSetId) {
        return exerciseSetRepository.findById(exerciseSetId)
                .orElseThrow(() -> new DataNotFoundException(Error.EXERCISESET_NOT_FOUND.getMessage()));
    }

    public List<ExerciseSetInfo> findAllExerciseSets() {
        List<ExerciseSet> exerciseSets = exerciseSetRepository.findAll();
        return exerciseSetMapper.toInfoList(exerciseSets);
    }
}
