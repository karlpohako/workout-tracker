package ee.karl.workouttracker.presistence.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select c from Category c where upper(c.name) = upper(?1)")
    Optional<Category> findCategoryByName(String name);
}