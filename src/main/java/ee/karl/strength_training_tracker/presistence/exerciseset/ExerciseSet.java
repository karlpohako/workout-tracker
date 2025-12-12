package ee.karl.strength_training_tracker.presistence.exerciseset;

import ee.karl.strength_training_tracker.presistence.workoutexercise.WorkoutExercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "EXERCISE_SET")
public class ExerciseSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "WORKOUT_EXERCISE_ID", nullable = false)
    private WorkoutExercise workoutExercise;

    @Size(max = 20)
    @NotNull
    @Column(name = "SET_TYPE", nullable = false, length = 20)
    private String setType;

    @NotNull
    @Column(name = "SET_NUMBER", nullable = false)
    private Integer setNumber;

    @Column(name = "WEIGHT_KG", precision = 5, scale = 2)
    private BigDecimal weightKg;

    @NotNull
    @Column(name = "REPS", nullable = false)
    private Integer reps;

    @Column(name = "RPE")
    private Integer rpe;

    @Size(max = 2000)
    @Column(name = "NOTES", length = 2000)
    private String notes;

    @NotNull
    @Column(name = "COMPLETED", nullable = false)
    private Boolean completed;


}