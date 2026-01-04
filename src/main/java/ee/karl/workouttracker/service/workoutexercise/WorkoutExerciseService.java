package ee.karl.workouttracker.service.workoutexercise;

import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseInfo;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExerciseMapper;
import ee.karl.workouttracker.presistence.workoutexercise.WorkoutExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkoutExerciseService {

    private final WorkoutExerciseMapper workoutExerciseMapper;
    private final WorkoutExerciseRepository workoutExerciseRepository;

    public List<WorkoutExerciseInfo> getWorkoutExercises() {
        return workoutExerciseMapper.toInfoDtos(workoutExerciseRepository.findAll());
    }
}
