package ee.karl.workouttracker.service.workout;

import ee.karl.workouttracker.controller.workout.dto.WorkoutDto;
import ee.karl.workouttracker.controller.workout.dto.WorkoutInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.workout.Workout;
import ee.karl.workouttracker.presistence.workout.WorkoutMapper;
import ee.karl.workouttracker.presistence.workout.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;

    public WorkoutDto findWorkoutById(Integer workoutId) {
        Workout workout = getWorkoutBy(workoutId);
        return workoutMapper.toWorkoutDto(workout);
    }

    public List<WorkoutInfo> findAllWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();
        return workoutMapper.toWorkoutInfoDtos(workouts);
    }

    private Workout getWorkoutBy(Integer workoutId) {
        return workoutRepository.findById(workoutId)
                .orElseThrow(() -> new DataNotFoundException(Error.WORKOUT_NOT_FOUND.getMessage()));
    }

}
