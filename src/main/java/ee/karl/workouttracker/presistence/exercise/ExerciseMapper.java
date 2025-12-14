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
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "muscleGroup", source = "muscleGroup.name")
    @Mapping(target = "equipmentType", source = "equipmentType.name")
    ExerciseDto toExerciseDto(Exercise exercise);

    @InheritConfiguration(name = "toExerciseDto")
    @Mapping(target = "exerciseId", source = "id")
    @Mapping(target = "createdAt", source = "createdAt")
    ExerciseInfoDto toExerciseInfoDto(Exercise exercise);

    List<ExerciseInfoDto> toExerciseInfoDtos(List<Exercise> all);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "muscleGroup", ignore = true)
    @Mapping(target = "equipmentType", ignore = true)
    Exercise toExercise(ExerciseDto exerciseDto);
}
