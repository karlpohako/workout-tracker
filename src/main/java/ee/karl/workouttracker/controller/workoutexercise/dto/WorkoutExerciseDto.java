package ee.karl.workouttracker.controller.workoutexercise.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class WorkoutExerciseDto implements Serializable {

    @NotNull
    Integer workoutId;

    @NotNull
    Integer exerciseId;

    @NotNull
    Integer orderIndex;

    @NotNull
    @Size(max = 2000)
    String notes;
}