package ee.karl.workouttracker.controller.workout.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkoutDto implements Serializable {

    @NotNull
    @Size(max = 100)
    String name;

    @Size(max = 2000)
    String notes;
}