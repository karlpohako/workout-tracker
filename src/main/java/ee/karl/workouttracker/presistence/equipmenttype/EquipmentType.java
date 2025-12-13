package ee.karl.workouttracker.presistence.equipmenttype;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EQUIPMENT_TYPE")
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;


}