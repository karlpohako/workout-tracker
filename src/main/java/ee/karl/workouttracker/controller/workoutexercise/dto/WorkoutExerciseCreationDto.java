package ee.karl.workouttracker.controller.workoutexercise.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class WorkoutExerciseCreationDto implements Serializable {

    @NotNull
    Integer exerciseId;

    @Positive
    @NotNull
    Integer orderIndex;

    @Size(max = 2000)
    String notes;
}