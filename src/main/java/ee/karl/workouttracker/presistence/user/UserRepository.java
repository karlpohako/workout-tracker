package ee.karl.workouttracker.presistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select (count(u) > 0) from User u where upper(u.username) = upper(?1)")
    boolean existsByUsername(String username);
}