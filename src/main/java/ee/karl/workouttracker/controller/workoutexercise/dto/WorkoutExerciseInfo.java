package ee.karl.workouttracker.controller.workoutexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WorkoutExerciseInfo extends WorkoutExerciseDto implements Serializable {

    Integer id;
}