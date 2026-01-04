package ee.karl.workouttracker.controller.workoutexercise;

import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseInfo;
import ee.karl.workouttracker.service.workoutexercise.WorkoutExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/workoutExercise")
class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;

    @GetMapping("/workoutexercises")
    @Operation(summary = "Get all workout exercises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all workout exercises")
    })
    public List<WorkoutExerciseInfo> getWorkoutExercises() {
        return workoutExerciseService.getWorkoutExercises();
    }

}
