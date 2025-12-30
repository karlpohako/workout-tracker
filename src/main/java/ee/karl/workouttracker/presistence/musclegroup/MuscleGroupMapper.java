package ee.karl.workouttracker.presistence.musclegroup;

import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupDto;
import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MuscleGroupMapper {

    @Mapping(target = "name", source = "name")
    MuscleGroup toEntity(MuscleGroupDto muscleGroupDto);

    @Mapping(target = "name", source = "name")
    MuscleGroupDto toDto(MuscleGroup muscleGroup);

    @InheritConfiguration(name = "toDto")
    @Mapping(target = "id", source = "id")
    MuscleGroupInfo toInfoDto(MuscleGroup muscleGroup);

    List<MuscleGroupInfo> toInfoDtos(List<MuscleGroup> muscleGroups);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MuscleGroup updateMuscleGroup(MuscleGroupDto muscleGroupDto, @MappingTarget MuscleGroup muscleGroup);
}