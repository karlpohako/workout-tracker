package ee.karl.workouttracker.presistence.workoutexercise;

import ee.karl.workouttracker.presistence.exercise.Exercise;
import ee.karl.workouttracker.presistence.workout.Workout;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "WORKOUT_EXERCISE")
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "WORKOUT_ID", nullable = false)
    private Workout workout;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EXERCISE_ID", nullable = false)
    private Exercise exercise;

    @NotNull
    @Positive
    @Column(name = "ORDER_INDEX", nullable = false)
    private Integer orderIndex;

    @Size(max = 2000)
    @Column(name = "NOTES", nullable = false, length = 2000)
    private String notes;


}