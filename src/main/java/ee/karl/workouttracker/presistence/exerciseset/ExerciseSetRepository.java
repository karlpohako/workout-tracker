package ee.karl.workouttracker.presistence.exerciseset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Integer> {

    @Query("select (count(e) > 0) from ExerciseSet e where e.setType.id = ?1")
    boolean isSetTypeUsedInExerciseSetBy(Integer id);

    @Modifying
    @Query("DELETE FROM ExerciseSet es WHERE es.workoutExercise.id = :workoutExerciseId")
    void deleteAllByWorkoutExerciseId(@Param("workoutExerciseId") Integer workoutExerciseId);

}