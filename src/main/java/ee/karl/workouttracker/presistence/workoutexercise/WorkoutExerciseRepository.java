package ee.karl.workouttracker.presistence.workoutexercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Integer> {
}