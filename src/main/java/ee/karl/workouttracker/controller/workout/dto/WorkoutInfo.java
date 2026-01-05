package ee.karl.workouttracker.controller.workout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WorkoutInfo extends WorkoutDto implements Serializable {

    private Integer id;
    private Instant createdAt;
}
