package ee.karl.workouttracker.presistence.workoutexercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Integer> {

    @Query("select (count(w) > 0) from WorkoutExercise w where w.exercise.id = ?1")
    boolean isExerciseUsedInWorkoutBy(Integer id);
}