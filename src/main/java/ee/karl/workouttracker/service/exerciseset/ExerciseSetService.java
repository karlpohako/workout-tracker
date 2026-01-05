package ee.karl.workouttracker.service.exerciseset;

import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetCreation;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetDto;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetInfo;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetUpdate;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.exerciseset.ExerciseSet;
import ee.karl.workouttracker.presistence.exerciseset.ExerciseSetMapper;
import ee.karl.workouttracker.presistence.exerciseset.ExerciseSetRepository;
import ee.karl.workouttracker.presistence.settype.SetType;
import ee.karl.workouttracker.presistence.settype.SetTypeRepository;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExercise;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExerciseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseSetService {

    private final ExerciseSetRepository exerciseSetRepository;
    private final ExerciseSetMapper exerciseSetMapper;
    private final SetTypeRepository setTypeRepository;
    private final WorkoutExerciseRepository workoutExerciseRepository;

    @Transactional
    public void saveExerciseSet(Integer workoutExerciseId, ExerciseSetCreation exerciseSetCreation) {
        ExerciseSet exerciseSet = createExerciseSet(workoutExerciseId, exerciseSetCreation);
        exerciseSetRepository.save(exerciseSet);
    }

    public ExerciseSetDto findExerciseSetById(Integer exerciseSetId) {
        ExerciseSet exerciseSet = getExerciseSet(exerciseSetId);
        return exerciseSetMapper.toDto(exerciseSet);
    }

    public List<ExerciseSetInfo> findAllExerciseSets() {
        List<ExerciseSet> exerciseSets = exerciseSetRepository.findAll();
        return exerciseSetMapper.toInfoList(exerciseSets);
    }

    @Transactional
    public void updateExerciseSet(Integer exerciseSetId, ExerciseSetUpdate exerciseSetUpdate) {
        SetType setType = getSetType(exerciseSetUpdate.getSetTypeId());
        ExerciseSet exerciseSet = adjustSetNumberOnUpdate(exerciseSetId, exerciseSetUpdate.getSetNumber());

        exerciseSetMapper.updateToEntity(exerciseSetUpdate, exerciseSet);

        exerciseSet.setSetType(setType);

        exerciseSetRepository.save(exerciseSet);
    }

    private ExerciseSet adjustSetNumberOnUpdate(Integer exerciseSetId, Integer requestSetNumber) {
        ExerciseSet exerciseSet = getExerciseSet(exerciseSetId);
        Integer currentSetNumber = exerciseSet.getSetNumber();
        Integer workoutExerciseId = exerciseSet.getWorkoutExercise().getId();

        Integer maxSetNumber = exerciseSetRepository.findMaxSetNumberByWorkoutExerciseId(workoutExerciseId);
        Integer targetSetNumber = Math.max(1, Math.min(maxSetNumber, requestSetNumber));

        if (currentSetNumber.equals(targetSetNumber)) {
            return exerciseSet;
        }

        shiftSetNumbersForReOrdering(workoutExerciseId, targetSetNumber, currentSetNumber);

        exerciseSet.setSetNumber(targetSetNumber);

        return exerciseSet;
    }

    private void shiftSetNumbersForReOrdering(Integer workoutExerciseId, Integer targetSetNumber, Integer currentSetNumber) {
        if (targetSetNumber > currentSetNumber) {
            // Moving set from position 2 to 5: shift sets 3,4,5 down to 2,3,4
            exerciseSetRepository.shiftSetNumbersBackward(workoutExerciseId, currentSetNumber, targetSetNumber);
        } else {
            // Moving set from position 5 to 2: shift sets 2,3,4 up to 3,4,5
            exerciseSetRepository.shiftSetNumbersForward(workoutExerciseId, targetSetNumber, currentSetNumber);
        }
    }

    private ExerciseSet createExerciseSet(Integer workoutExerciseId, ExerciseSetCreation exerciseSetCreation) {
        WorkoutExercise workoutExercise = getWorkoutExercise(workoutExerciseId);
        SetType setType = getSetType(exerciseSetCreation.getSetTypeId());

        Integer adjustedSetNumber = adjustSetNumberOnCreation(workoutExerciseId, exerciseSetCreation.getSetNumber());

        exerciseSetRepository.shiftSetNumbersOnCreation(workoutExerciseId, adjustedSetNumber);

        ExerciseSet exerciseSet = exerciseSetMapper.creationToEntity(exerciseSetCreation);

        exerciseSet.setSetNumber(adjustedSetNumber);
        exerciseSet.setWorkoutExercise(workoutExercise);
        exerciseSet.setSetType(setType);

        return exerciseSet;
    }

    private Integer adjustSetNumberOnCreation(Integer workoutExerciseId, Integer setNumber) {
        Integer currentMaxSet = exerciseSetRepository.findMaxSetNumberByWorkoutExerciseId(workoutExerciseId);

        if (currentMaxSet != null && setNumber > currentMaxSet + 1) {
            setNumber = currentMaxSet + 1;
        } else if (currentMaxSet == null) {
            setNumber = 1;
        }
        return setNumber;
    }

    private ExerciseSet getExerciseSet(Integer exerciseSetId) {
        return exerciseSetRepository.findById(exerciseSetId)
                .orElseThrow(() -> new DataNotFoundException(Error.EXERCISESET_NOT_FOUND.getMessage()));
    }

    private WorkoutExercise getWorkoutExercise(Integer workoutExerciseId) {
        return workoutExerciseRepository.findById(workoutExerciseId)
                .orElseThrow(() -> new DataNotFoundException(Error.WORKOUTEXERCISE_NOT_FOUND.getMessage()));
    }

    private SetType getSetType(Integer setTypeId) {
        return setTypeRepository.findById(setTypeId)
                .orElseThrow(() -> new DataNotFoundException(Error.SET_TYPE_NOT_FOUND.getMessage()));
    }
}
