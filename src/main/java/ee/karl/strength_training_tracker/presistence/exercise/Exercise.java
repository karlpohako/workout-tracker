package ee.karl.strength_training_tracker.presistence.exercise;

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

    @Size(max = 20)
    @NotNull
    @Column(name = "CATEGORY", nullable = false, length = 20)
    private String category;

    @Size(max = 20)
    @Column(name = "MUSCLE_GROUP", length = 20)
    private String muscleGroup;

    @Size(max = 20)
    @Column(name = "EQUIPMENT_TYPE", length = 20)
    private String equipmentType;

    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    private Instant createdAt;


}