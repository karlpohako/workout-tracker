package ee.karl.workouttracker.presistence.exercise;

import ee.karl.workouttracker.controller.exercise.dto.ExerciseDto;
import ee.karl.workouttracker.controller.exercise.dto.ExerciseInfoDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExerciseMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "muscleGroup", source = "muscleGroup")
    @Mapping(target = "equipmentType", source = "equipmentType")
    @Mapping(target = "createdAt", source = "createdAt")
    ExerciseDto toExerciseDto(Exercise exercise);

    @InheritConfiguration(name = "toExerciseDto")
    @Mapping(target = "exerciseId", source = "id")
    ExerciseInfoDto toExerciseInfoDto(Exercise exercise);

    List<ExerciseInfoDto> toExerciseInfoDtos(List<Exercise> all);
}
