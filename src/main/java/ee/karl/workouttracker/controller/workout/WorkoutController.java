package ee.karl.workouttracker.controller.workout;

import ee.karl.workouttracker.controller.workout.dto.CreateWorkoutDto;
import ee.karl.workouttracker.controller.workout.dto.WorkoutDto;
import ee.karl.workouttracker.controller.workout.dto.WorkoutInfo;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.workout.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping("/{userId}/create")
    @Operation(summary = "Create a new workout", description = "Creates a new workout with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workout created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid workout data provided",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "User with the specified ID not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void createWorkout(@PathVariable Integer userId, @RequestBody CreateWorkoutDto createWorkoutDto) {
        workoutService.saveWorkout(userId, createWorkoutDto);
    }

    @GetMapping("/{workoutId}")
    @Operation(summary = "Find workout by id", description = "Returns workout by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workout found successfully"),
            @ApiResponse(responseCode = "404", description = "Workout with the specified ID not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public WorkoutDto findWorkoutById(@PathVariable Integer workoutId) {
        return workoutService.findWorkoutById(workoutId);
    }

    @GetMapping("/workouts")
    @Operation(summary = "Find all workouts", description = "Returns all workouts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workouts retrieved successfully")
    })
    public List<WorkoutInfo> findAllWorkouts() {
        return workoutService.findAllWorkouts();
    }

}
