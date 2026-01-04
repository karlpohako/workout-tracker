package ee.karl.workouttracker.presistence.workoutexercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Integer> {

    @Query("select max(we.orderIndex) from WorkoutExercise we where we.workout.id = ?1")
    Integer findWorkOutExerciseMaxOrderIndex(Integer workoutId);

    @Transactional
    @Modifying
    @Query("UPDATE WorkoutExercise we SET we.orderIndex = we.orderIndex + 1 " +
            "WHERE we.workout.id = :workoutId AND we.orderIndex >= :fromIndex")
    void shiftOrderIndexes(@Param("workoutId") Integer workoutId,
                           @Param("fromIndex") Integer fromIndex);


    @Query("select (count(w) > 0) from WorkoutExercise w where w.exercise.id = ?1")
    boolean isExerciseUsedInWorkoutBy(Integer id);
}