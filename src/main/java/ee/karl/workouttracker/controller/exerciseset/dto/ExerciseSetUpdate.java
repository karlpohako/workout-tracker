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
public class ExerciseSetUpdate implements Serializable {

    @NotNull
    Integer setTypeId;

    @NotNull
    Integer setNumber;

    BigDecimal weightKg;

    Integer reps;

    Integer rpe;

    @Size(max = 2000)
    String notes;

    @NotNull
    Boolean completed;
}