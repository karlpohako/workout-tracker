package ee.karl.workouttracker.service.musclegroup;

import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupDto;
import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.infrastructure.rest.exception.DatabaseNameConflictException;
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

    public void saveMuscleGroup(MuscleGroupDto muscleGroupDto) {
        MuscleGroup muscleGroup = createMuscleGroup(muscleGroupDto);
        muscleGroupRepository.save(muscleGroup);
    }

    public List<MuscleGroupInfo> findAllMuscleGroups() {
        return muscleGroupMapper.toInfoDtos(muscleGroupRepository.findAll());
    }

    public MuscleGroupDto findMuscleGroupById(Integer muscleGroupId) {
        MuscleGroup muscleGroup = muscleGroupRepository.findById(muscleGroupId).orElseThrow(
                () -> new DataNotFoundException(Error.MUSCLE_GROUP_NOT_FOUND.getMessage()));
        return muscleGroupMapper.toDto(muscleGroup);
    }

    private MuscleGroup createMuscleGroup(MuscleGroupDto muscleGroupDto) {
        String name = muscleGroupDto.getName();
        boolean muscleGroupExistsByName = muscleGroupRepository.muscleGroupExistsBy(name);
        if (muscleGroupExistsByName) {
            throw new DatabaseNameConflictException(Error.MUSCLE_GROUP_ALREADY_EXISTS.getMessage());
        }
        return muscleGroupMapper.toEntity(muscleGroupDto);
    }
}
