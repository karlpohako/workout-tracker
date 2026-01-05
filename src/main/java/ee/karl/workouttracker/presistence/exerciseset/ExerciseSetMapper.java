package ee.karl.workouttracker.presistence.exerciseset;

import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExerciseSetMapper {

    ExerciseSet toEntity(ExerciseSetDto exerciseSetDto);

    @Mapping(target = "workoutExerciseWorkoutName", source = "workoutExercise.workout.name")
    @Mapping(target = "workoutExerciseOrderIndex", source = "workoutExercise.orderIndex")
    @Mapping(target = "setTypeName", source = "setType.name")
    @Mapping(target = "setNumber", source = "setNumber")
    @Mapping(target = "weightKg", source = "weightKg")
    @Mapping(target = "reps", source = "reps")
    @Mapping(target = "rpe", source = "rpe")
    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "completed", source = "completed")
    ExerciseSetDto toDto(ExerciseSet exerciseSet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ExerciseSet partialUpdate(ExerciseSetDto exerciseSetDto, @MappingTarget ExerciseSet exerciseSet);
}