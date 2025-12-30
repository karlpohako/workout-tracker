package ee.karl.workouttracker.controller.musclegroup.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
public class MuscleGroupDto implements Serializable {

    @NotNull
    @Size(max = 100)
    String name;
}