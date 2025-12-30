package ee.karl.workouttracker.service.musclegroup;

import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupInfo;
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

    public List<MuscleGroupInfo> findAllMuscleGroups() {
        return muscleGroupMapper.toInfoDtos(muscleGroupRepository.findAll());
    }

}
