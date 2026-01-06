package ee.karl.workouttracker.presistence.workout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

    @Query("select w from Workout w where w.user.id = ?1")
    List<Workout> findAllByUserId(Integer id);
}