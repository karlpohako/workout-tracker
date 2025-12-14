package ee.karl.workouttracker.controller.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ExerciseInfoDto extends ExerciseDto {

    private Integer exerciseId;
    private Instant createdAt;

}
