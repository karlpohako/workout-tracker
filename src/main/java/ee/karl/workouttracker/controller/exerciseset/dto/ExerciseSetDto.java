package ee.karl.workouttracker.controller.exerciseset.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseSetDto implements Serializable {

    String workoutExerciseWorkoutName;

    Integer workoutExerciseOrderIndex;

    String workoutExerciseExerciseName;

    String setTypeName;

    @NotNull
    Integer setNumber;

    BigDecimal weightKg;

    @NotNull
    Integer reps;

    Integer rpe;

    @Size(max = 2000)
    String notes;

    @NotNull
    Boolean completed;
}