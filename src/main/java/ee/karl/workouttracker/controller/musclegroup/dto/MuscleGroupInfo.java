package ee.karl.workouttracker.controller.musclegroup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MuscleGroupInfo extends MuscleGroupDto implements Serializable {

    Integer id;
}