package ee.karl.workouttracker.presistence.workoutexercise;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE WorkoutExercise we SET we.orderIndex = we.orderIndex + 1 " +
            "WHERE we.workout.id = :workoutId " +
            "AND we.orderIndex >= :newIndex " +
            "AND we.orderIndex < :oldIndex")
    void shiftDownForMoveDown(@Param("workoutId") Integer workoutId,
                              @Param("newIndex") Integer newIndex,
                              @Param("oldIndex") Integer oldIndex);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE WorkoutExercise we SET we.orderIndex = we.orderIndex - 1 " +
            "WHERE we.workout.id = :workoutId " +
            "AND we.orderIndex > :oldIndex " +
            "AND we.orderIndex <= :newIndex")
    void shiftUpForMoveUp(@Param("workoutId") Integer workoutId,
                          @Param("oldIndex") Integer oldIndex,
                          @Param("newIndex") Integer newIndex);

    @Query("select max(we.orderIndex) from WorkoutExercise we where we.workout.id = ?1")
    Integer findWorkOutExerciseMaxOrderIndex(Integer workoutId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE WorkoutExercise we SET we.orderIndex = we.orderIndex + 1 " +
            "WHERE we.workout.id = :workoutId AND we.orderIndex >= :fromIndex")
    void shiftOrderIndexesOnCreation(@Param("workoutId") Integer workoutId,
                                     @Param("fromIndex") Integer fromIndex);


    @Query("select (count(w) > 0) from WorkoutExercise w where w.exercise.id = ?1")
    boolean isExerciseUsedInWorkoutBy(Integer id);
}