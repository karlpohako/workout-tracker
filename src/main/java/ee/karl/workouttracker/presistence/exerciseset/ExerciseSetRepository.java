package ee.karl.workouttracker.presistence.exerciseset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Integer> {

    @Query("select (count(e) > 0) from ExerciseSet e where e.setType.id = ?1")
    boolean isSetTypeUsedInExerciseSetBy(Integer id);

    @Modifying
    @Query("DELETE FROM ExerciseSet es WHERE es.workoutExercise.id = :workoutExerciseId")
    void deleteAllByWorkoutExerciseId(@Param("workoutExerciseId") Integer workoutExerciseId);

    @Query("SELECT MAX(es.setNumber) FROM ExerciseSet es WHERE es.workoutExercise.id = :workoutExerciseId")
    Integer findMaxSetNumberByWorkoutExerciseId(@Param("workoutExerciseId") Integer workoutExerciseId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ExerciseSet es SET es.setNumber = es.setNumber + 1 " +
            "WHERE es.workoutExercise.id = :workoutExerciseId AND es.setNumber >= :fromSetNumber")
    void shiftSetNumbersOnCreation(@Param("workoutExerciseId") Integer workoutExerciseId,
                                   @Param("fromSetNumber") Integer fromSetNumber);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ExerciseSet es SET es.setNumber = es.setNumber + 1 " +
            "WHERE es.workoutExercise.id = :workoutExerciseId " +
            "AND es.setNumber >= :rangeStart " +
            "AND es.setNumber < :rangeEnd")
    void shiftSetNumbersForward(Integer workoutExerciseId, Integer rangeStart, Integer rangeEnd);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ExerciseSet es SET es.setNumber = es.setNumber - 1 " +
            "WHERE es.workoutExercise.id = :workoutExerciseId " +
            "AND es.setNumber > :rangeStart " +
            "AND es.setNumber <= :rangeEnd")
    void shiftSetNumbersBackward(Integer workoutExerciseId, Integer rangeStart, Integer rangeEnd);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ExerciseSet es SET es.setNumber = es.setNumber - 1 " +
            "WHERE es.workoutExercise.id = :workoutExerciseId " +
            "AND es.setNumber > :deletedSetNumber")
    void shiftSetNumbersAfterDeletion(@Param("workoutExerciseId") Integer workoutExerciseId,
                                      @Param("deletedSetNumber") Integer deletedSetNumber);

    @Query("select e from ExerciseSet e where e.workoutExercise.id = ?1")
    List<ExerciseSet> findAllByWorkoutExerciseId(Integer id);

}