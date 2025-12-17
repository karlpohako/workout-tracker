package ee.karl.workouttracker.presistence.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    @Query("select (count(e) > 0) from Exercise e where upper(e.name) = upper(?1) and upper(e.category.name) = upper(?2)")
    boolean findExerciseByNameAndCategory(String exerciseName, String categoryName);

    @Query("select (count(e) > 0) from Exercise e where e.category.id = ?1")
    boolean isCategoryUsedInExercisesBy(Integer categoryId);

}