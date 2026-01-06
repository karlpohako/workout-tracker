package ee.karl.workouttracker.service.workout;

import ee.karl.workouttracker.controller.workout.dto.CreateWorkoutDto;
import ee.karl.workouttracker.controller.workout.dto.UpdateWorkoutDto;
import ee.karl.workouttracker.controller.workout.dto.WorkoutDto;
import ee.karl.workouttracker.controller.workout.dto.WorkoutInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.user.User;
import ee.karl.workouttracker.presistence.user.UserRepository;
import ee.karl.workouttracker.presistence.workout.Workout;
import ee.karl.workouttracker.presistence.workout.WorkoutMapper;
import ee.karl.workouttracker.presistence.workout.WorkoutRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;
    private final UserRepository userRepository;

    public void saveWorkout(Integer userId, CreateWorkoutDto createWorkoutDto) {
        Workout workout = createWorkout(userId, createWorkoutDto);
        workoutRepository.save(workout);

    }

    public WorkoutDto findWorkoutById(Integer workoutId) {
        Workout workout = getWorkoutBy(workoutId);
        return workoutMapper.toWorkoutDto(workout);
    }

    public List<WorkoutInfo> findAllWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();
        return workoutMapper.toWorkoutInfoDtos(workouts);
    }

    public void updateWorkout(Integer workoutId, UpdateWorkoutDto updateWorkoutDto) {
        Workout workout = getWorkoutBy(workoutId);
        workoutMapper.updateDtoToWorkout(updateWorkoutDto, workout);
        workoutRepository.save(workout);
    }

    public void completeWorkout(Integer workoutId) {
        Workout workout = getWorkoutBy(workoutId);
        Integer durationMinutes = calculateWorkoutDuration(workout);

        workout.setDurationMinutes(durationMinutes);
        workoutRepository.save(workout);
    }

    @Transactional
    public void deleteWorkout(Integer workoutId) {
        doesWorkoutExist(workoutId);
        workoutRepository.deleteById(workoutId);
    }

    private Integer calculateWorkoutDuration(Workout workout) {
        workout.setEndTime(LocalTime.now());
        Duration duration = Duration.between(workout.getStartTime(), workout.getEndTime());
        return (int) duration.toMinutes();
    }

    private void doesWorkoutExist(Integer workoutId) {
        if (!workoutRepository.existsById(workoutId)) {
            throw new DataNotFoundException(Error.WORKOUT_NOT_FOUND.getMessage());
        }
    }

    private Workout createWorkout(Integer userId, CreateWorkoutDto createWorkoutDto) {
        Workout workout = workoutMapper.createDtoToWorkout(createWorkoutDto);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException(Error.USER_NOT_FOUND.getMessage()));
        workout.setUser(user);
        workout.setDate(LocalDate.now());
        workout.setStartTime(LocalTime.now());
        return workout;
    }

    private Workout getWorkoutBy(Integer workoutId) {
        return workoutRepository.findById(workoutId)
                .orElseThrow(() -> new DataNotFoundException(Error.WORKOUT_NOT_FOUND.getMessage()));
    }
}
