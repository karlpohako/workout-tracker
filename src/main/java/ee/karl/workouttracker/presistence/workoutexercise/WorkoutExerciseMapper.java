package ee.karl.workouttracker.presistence.workoutexercise;

import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WorkoutExerciseMapper {

    @Mapping(target = "workout.id", source = "workoutId")
    @Mapping(target = "exercise.id", source = "exerciseId")
    @Mapping(target = "orderIndex", source = "orderIndex")
    @Mapping(target = "notes", source = "notes")
    WorkoutExercise toEntity(WorkoutExerciseDto workoutExerciseDto);

    @Mapping(target = "workoutId", source = "workout.id")
    @Mapping(target = "exerciseId", source = "exercise.id")
    @Mapping(target = "orderIndex", source = "orderIndex")
    @Mapping(target = "notes", source = "notes")
    WorkoutExerciseDto toDto(WorkoutExercise workoutExercise);

    @InheritConfiguration(name = "toDto")
    @Mapping(target = "id", source = "id")
    WorkoutExerciseInfo toInfoDto(WorkoutExercise workoutExercise);

    List<WorkoutExerciseInfo> toInfoDtos(List<WorkoutExercise> workoutExercises);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WorkoutExercise partialUpdate(WorkoutExerciseDto workoutExerciseDto, @MappingTarget WorkoutExercise workoutExercise);
}