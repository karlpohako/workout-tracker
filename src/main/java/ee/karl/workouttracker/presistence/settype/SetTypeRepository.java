package ee.karl.workouttracker.presistence.settype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SetTypeRepository extends JpaRepository<SetType, Integer> {

    @Query("select (count(s) > 0) from SetType s where upper(s.name) = upper(?1)")
    boolean existsByName(String name);
}