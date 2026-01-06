package ee.karl.workouttracker.controller.workoutexercise;

import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseCreationDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseDto;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseInfo;
import ee.karl.workouttracker.controller.workoutexercise.dto.WorkoutExerciseUpdateDto;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.workoutexercise.WorkoutExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/workoutExercise")
class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;

    @PostMapping("/{workoutId}/create")
    @Operation(summary = "Create a new workout exercise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workout exercise created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid workout exercise data",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Exercise not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Workout not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void createWorkoutExercise(@PathVariable Integer workoutId, @Valid @RequestBody WorkoutExerciseCreationDto workoutExerciseCreationDto) {
        workoutExerciseService.saveWorkoutExercise(workoutId, workoutExerciseCreationDto);
    }

    @GetMapping("/{workoutExerciseId}")
    @Operation(summary = "Get workout exercise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns workout exercise with specified ID"),
            @ApiResponse(responseCode = "404", description = "Workout exercise not found")
    })
    public WorkoutExerciseDto getWorkoutExerciseById(@PathVariable Integer workoutExerciseId) {
        return workoutExerciseService.findWorkoutExercise(workoutExerciseId);
    }

    @GetMapping("/workoutexercises")
    @Operation(summary = "Get all workout exercises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all workout exercises")
    })
    public List<WorkoutExerciseInfo> getWorkoutExercises() {
        return workoutExerciseService.findAllWorkoutExercises();
    }

    @PutMapping("/{workoutExerciseId}")
    @Operation(summary = "Update workout exercise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workout exercise updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid workout exercise data",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Workout nor found",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Workout exercise not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateWorkoutExercise(@PathVariable Integer workoutExerciseId, @Valid @RequestBody WorkoutExerciseUpdateDto workoutExerciseDto) {
        workoutExerciseService.updateWorkoutExercise(workoutExerciseId, workoutExerciseDto);
    }

    @DeleteMapping("/{workoutExerciseId}")
    @Operation(summary = "Delete workout exercise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Workout exercise deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Workout exercise not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void deleteWorkoutExercise(@PathVariable Integer workoutExerciseId) {
        workoutExerciseService.deleteWorkoutExercise(workoutExerciseId);
    }
}
