package ee.karl.workouttracker.presistence.exerciseset;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Integer> {
}