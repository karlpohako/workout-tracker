package ee.karl.workouttracker.controller.exercise.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ExerciseDto {

    @NotNull
    @Size(max = 100)
    private String name;
    @Size(max = 5000)
    private String description;
    @NotNull
    @Size(max = 100)
    private String category;
    @NotNull
    @Size(max = 100)
    private String muscleGroup;
    @NotNull
    @Size(max = 100)
    private String equipmentType;

}
