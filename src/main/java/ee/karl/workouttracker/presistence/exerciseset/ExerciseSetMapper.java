package ee.karl.workouttracker.presistence.exerciseset;

import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetCreation;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetDto;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetInfo;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetUpdate;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExerciseSetMapper {

    @Mapping(target = "workoutExerciseWorkoutName", source = "workoutExercise.workout.name")
    @Mapping(target = "workoutExerciseOrderIndex", source = "workoutExercise.orderIndex")
    @Mapping(target = "workoutExerciseExerciseName", source = "workoutExercise.exercise.name")
    @Mapping(target = "setTypeName", source = "setType.name")
    @Mapping(target = "setNumber", source = "setNumber")
    @Mapping(target = "weightKg", source = "weightKg")
    @Mapping(target = "reps", source = "reps")
    @Mapping(target = "rpe", source = "rpe")
    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "completed", source = "completed")
    ExerciseSetDto toDto(ExerciseSet exerciseSet);

    @InheritConfiguration(name = "toDto")
    @Mapping(target = "id", source = "id")
    ExerciseSetInfo toInfo(ExerciseSet exerciseSet);

    List<ExerciseSetInfo> toInfoList(List<ExerciseSet> exerciseSets);

    @Mapping(target = "weightKg", source = "weightKg")
    @Mapping(target = "reps", source = "reps")
    @Mapping(target = "rpe", source = "rpe")
    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "completed", source = "completed")
    ExerciseSet creationToEntity(ExerciseSetCreation creation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @InheritConfiguration(name = "creationToEntity")
    ExerciseSet updateToEntity(ExerciseSetUpdate update, @MappingTarget ExerciseSet exerciseSet);

}