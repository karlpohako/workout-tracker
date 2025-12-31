package ee.karl.workouttracker.service.musclegroup;

import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupDto;
import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataInUseException;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.infrastructure.rest.exception.DatabaseNameConflictException;
import ee.karl.workouttracker.presistence.exercise.ExerciseRepository;
import ee.karl.workouttracker.presistence.musclegroup.MuscleGroup;
import ee.karl.workouttracker.presistence.musclegroup.MuscleGroupMapper;
import ee.karl.workouttracker.presistence.musclegroup.MuscleGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MuscleGroupService {

    private final MuscleGroupMapper muscleGroupMapper;
    private final MuscleGroupRepository muscleGroupRepository;
    private final ExerciseRepository exerciseRepository;

    public void saveMuscleGroup(MuscleGroupDto muscleGroupDto) {
        MuscleGroup muscleGroup = createMuscleGroup(muscleGroupDto);
        muscleGroupRepository.save(muscleGroup);
    }

    public List<MuscleGroupInfo> findAllMuscleGroups() {
        return muscleGroupMapper.toInfoDtos(muscleGroupRepository.findAll());
    }

    public MuscleGroupDto findMuscleGroupById(Integer muscleGroupId) {
        MuscleGroup muscleGroup = getMuscleGroup(muscleGroupId);
        return muscleGroupMapper.toDto(muscleGroup);
    }

    public void updateMuscleGroup(Integer muscleGroupId, MuscleGroupDto muscleGroupDto) {
        MuscleGroup muscleGroup = getMuscleGroup(muscleGroupId);
        muscleGroupMapper.updateMuscleGroup(muscleGroupDto, muscleGroup);
        muscleGroupRepository.save(muscleGroup);
    }

    public void deleteMuscleGroup(Integer muscleGroupId) {
        assertMuscleGroupExistAndNotInUse(muscleGroupId);
        muscleGroupRepository.deleteById(muscleGroupId);
    }

    private void assertMuscleGroupExistAndNotInUse(Integer muscleGroupId) {
        boolean exists = muscleGroupRepository.existsById(muscleGroupId);
        if (!exists) {
            throw new DataNotFoundException(Error.MUSCLE_GROUP_NOT_FOUND.getMessage());
        }
        boolean isUsed = exerciseRepository.isMuscleGroupUsedInExerciseBy(muscleGroupId);
        if (isUsed) {
            throw new DataInUseException(Error.MUSCLE_GROUP_IN_USE.getMessage());
        }
    }

    private MuscleGroup createMuscleGroup(MuscleGroupDto muscleGroupDto) {
        String name = muscleGroupDto.getName();
        boolean muscleGroupExistsByName = muscleGroupRepository.muscleGroupExistsBy(name);
        if (muscleGroupExistsByName) {
            throw new DatabaseNameConflictException(Error.MUSCLE_GROUP_ALREADY_EXISTS.getMessage());
        }
        return muscleGroupMapper.toEntity(muscleGroupDto);
    }

    private MuscleGroup getMuscleGroup(Integer muscleGroupId) {
        return muscleGroupRepository.findById(muscleGroupId).orElseThrow(
                () -> new DataNotFoundException(Error.MUSCLE_GROUP_NOT_FOUND.getMessage()));
    }
}
