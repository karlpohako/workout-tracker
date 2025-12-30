package ee.karl.workouttracker.controller.musclegroup.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class MuscleGroupInfo extends MuscleGroupDto implements Serializable {

    Integer id;
}