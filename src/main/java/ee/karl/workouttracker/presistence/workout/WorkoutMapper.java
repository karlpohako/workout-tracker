package ee.karl.workouttracker.presistence.workout;

import ee.karl.workouttracker.controller.workout.dto.WorkoutDto;
import ee.karl.workouttracker.controller.workout.dto.WorkoutInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WorkoutMapper {


    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "startTime", ignore = true)
    @Mapping(target = "endTime", ignore = true)
    @Mapping(target = "durationMinutes", ignore = true)
    @Mapping(target = "notes", source = "notes")
    Workout toWorkout(WorkoutDto workoutDto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    @Mapping(target = "durationMinutes", source = "durationMinutes")
    @Mapping(target = "notes", source = "notes")
    WorkoutDto toWorkoutDto(Workout workout);

    @InheritConfiguration(name = "toWorkoutDto")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "createdAt", source = "createdAt")
    WorkoutInfo toWorkoutInfoDto(Workout workout);

    List<WorkoutInfo> toWorkoutInfoDtos(List<Workout> workouts);

    @Mapping(target = "user.id", source = "userId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Workout updateWorkout(WorkoutDto workoutDto, @MappingTarget Workout workout);

}
