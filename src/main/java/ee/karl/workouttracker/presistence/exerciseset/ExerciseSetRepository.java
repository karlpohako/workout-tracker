package ee.karl.workouttracker.presistence.exerciseset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Integer> {

    @Query("select (count(e) > 0) from ExerciseSet e where e.setType.id = ?1")
    boolean isSetTypeUsedInExerciseSetBy(Integer id);
}