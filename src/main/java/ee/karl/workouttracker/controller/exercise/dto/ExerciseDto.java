package ee.karl.workouttracker.controller.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExerciseDto {

    private String name;
    private String description;
    private String category;
    private String muscleGroup;
    private String equipmentType;
    private Instant createdAt;

}
