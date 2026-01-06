package ee.karl.workouttracker.presistence.workoutexercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE WorkoutExercise we SET we.orderIndex = we.orderIndex + 1 " +
            "WHERE we.workout.id = :workoutId " +
            "AND we.orderIndex >= :rangeStart " +
            "AND we.orderIndex < :rangeEnd")
    void incrementOrderIndexInRange(Integer workoutId, Integer rangeStart, Integer rangeEnd);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE WorkoutExercise we SET we.orderIndex = we.orderIndex - 1 " +
            "WHERE we.workout.id = :workoutId " +
            "AND we.orderIndex > :rangeStart " +
            "AND we.orderIndex <= :rangeEnd")
    void decrementOrderIndexInRange(Integer workoutId, Integer rangeStart, Integer rangeEnd);


    @Query("select max(we.orderIndex) from WorkoutExercise we where we.workout.id = ?1")
    Integer findWorkOutExerciseMaxOrderIndex(Integer workoutId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE WorkoutExercise we SET we.orderIndex = we.orderIndex + 1 " +
            "WHERE we.workout.id = :workoutId AND we.orderIndex >= :fromIndex")
    void shiftOrderIndexesOnCreation(@Param("workoutId") Integer workoutId,
                                     @Param("fromIndex") Integer fromIndex);


    @Query("select (count(w) > 0) from WorkoutExercise w where w.exercise.id = ?1")
    boolean isExerciseUsedInWorkoutBy(Integer id);

    @Query("select w from WorkoutExercise w where w.workout.id = ?1")
    List<WorkoutExercise> findAllByWorkoutId(Integer id);

}