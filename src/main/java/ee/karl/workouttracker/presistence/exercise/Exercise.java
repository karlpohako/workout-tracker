package ee.karl.workouttracker.presistence.exercise;

import ee.karl.workouttracker.presistence.category.Category;
import ee.karl.workouttracker.presistence.equipmenttype.EquipmentType;
import ee.karl.workouttracker.presistence.musclegroup.MuscleGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "EXERCISE")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Size(max = 5000)
    @Column(name = "DESCRIPTION", length = 5000)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MUSCLE_GROUP_ID", nullable = false)
    private MuscleGroup muscleGroup;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EQUIPMENT_TYPE_ID", nullable = false)
    private EquipmentType equipmentType;

    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    private Instant createdAt;


}