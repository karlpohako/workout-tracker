package ee.karl.workouttracker.presistence.workoutexercise;

import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseCreationDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseInfo;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseUpdateDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WorkoutExerciseMapper {

    @Mapping(target = "workoutId", source = "workout.id")
    @Mapping(target = "exerciseId", source = "exercise.id")
    @Mapping(target = "orderIndex", source = "orderIndex")
    @Mapping(target = "notes", source = "notes")
    WorkoutExerciseDto toDto(WorkoutExercise workoutExercise);

    @InheritConfiguration(name = "toDto")
    @Mapping(target = "id", source = "id")
    WorkoutExerciseInfo toInfoDto(WorkoutExercise workoutExercise);

    List<WorkoutExerciseInfo> toInfoDtos(List<WorkoutExercise> workoutExercises);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "workout", ignore = true)
    @Mapping(target = "exercise.id", ignore = true)
    @Mapping(target = "orderIndex", ignore = true)
    @Mapping(target = "notes", source = "notes")
    WorkoutExercise creationToEntity(WorkoutExerciseCreationDto workoutExerciseCreationDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "workout", ignore = true)
    @Mapping(target = "exercise.id", ignore = true)
    @Mapping(target = "orderIndex", ignore = true)
    @Mapping(target = "notes", source = "notes")
    WorkoutExercise updateDtoToEntity(WorkoutExerciseUpdateDto workoutExerciseUpdateDto, @MappingTarget WorkoutExercise workoutExercise);
}