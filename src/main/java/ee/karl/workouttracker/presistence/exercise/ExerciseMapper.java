package ee.karl.workouttracker.presistence.exercise;

import ee.karl.workouttracker.controller.exercise.dto.ExerciseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExerciseMapper {

    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "equipmentType", source = "equipmentType")
    @Mapping(target = "muscleGroup", source = "muscleGroup")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "name", source = "name")
    ExerciseDto toExerciseDto(Exercise exercise);
}
