package ee.karl.workouttracker.controller.workout.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDto implements Serializable {

    @NotNull
    private Integer userId;

    @Size(max = 100)
    @NotNull
    private String name;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer durationMinutes;

    @Size(max = 2000)
    private String notes;
}
