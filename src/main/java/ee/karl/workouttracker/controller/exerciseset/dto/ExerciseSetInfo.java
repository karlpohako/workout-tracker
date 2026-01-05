package ee.karl.workouttracker.controller.exerciseset.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExerciseSetInfo extends ExerciseSetDto implements Serializable {

    Integer id;
}