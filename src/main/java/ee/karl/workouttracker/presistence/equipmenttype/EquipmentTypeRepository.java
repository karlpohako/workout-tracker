package ee.karl.workouttracker.presistence.equipmenttype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Integer> {

    @Query("select e from EquipmentType e where upper(e.name) = upper(?1)")
    Optional<EquipmentType> findEquipmentTypeByName(String name);

    @Query("select (count(e) > 0) from EquipmentType e where upper(e.name) = upper(?1)")
    boolean existsByName(String name);

}