package ee.karl.workouttracker.controller.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExerciseInfoDto extends ExerciseDto {

    private Integer exerciseId;
    private Instant createdAt;

}
