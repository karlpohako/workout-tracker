package ee.karl.workouttracker.controller.workout.dto;

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
public class CreateWorkoutDto implements Serializable {

    @NotNull
    @Size(max = 100)
    String name;

    @Size(max = 2000)
    String notes;
}