package ee.karl.workouttracker.presistence.musclegroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Integer> {

    @Query("select m from MuscleGroup m where upper(m.name) = upper(?1)")
    Optional<MuscleGroup> findMuscleGroupByName(String name);
}