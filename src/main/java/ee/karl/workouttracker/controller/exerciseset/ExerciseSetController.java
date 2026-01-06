package ee.karl.workouttracker.controller.exerciseset;

import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetCreation;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetDto;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetInfo;
import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetUpdate;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.exerciseset.ExerciseSetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exerciseset")
@RequiredArgsConstructor
class ExerciseSetController {

    private final ExerciseSetService exerciseSetService;

    @PostMapping("/{workoutExerciseId}/create")
    @Operation(summary = "Create exercise set", description = "Creates a new exercise set")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise set created"),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Workout exercise not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Set type not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void createExerciseSet(@PathVariable Integer workoutExerciseId, @Valid @RequestBody ExerciseSetCreation exerciseSetCreation) {
        exerciseSetService.saveExerciseSet(workoutExerciseId, exerciseSetCreation);
    }

    @GetMapping("/{exerciseSetId}")
    @Operation(summary = "Get exercise set by id", description = "Returns exercise set by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise set found"),
            @ApiResponse(responseCode = "404", description = "Exercise set not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ExerciseSetDto getExerciseSet(@PathVariable Integer exerciseSetId) {
        return exerciseSetService.findExerciseSetById(exerciseSetId);
    }

    @GetMapping("/exercisesets")
    @Operation(summary = "Get all exercise sets", description = "Returns all exercise sets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise sets found")
    })
    public List<ExerciseSetInfo> getAllExerciseSets() {
        return exerciseSetService.findAllExerciseSets();
    }

    @GetMapping("/{workoutExerciseId}/exercisesets")
    @Operation(summary = "Get all exercise sets for a workout exercise", description = "Returns all exercise sets for a workout exercise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise sets found"),
            @ApiResponse(responseCode = "404", description = "Workout exercise not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public List<ExerciseSetInfo> getAllExerciseSetsForWorkoutExercise(@PathVariable Integer workoutExerciseId) {
        return exerciseSetService.findAllExerciseSetsForWorkoutExercise(workoutExerciseId);
    }

    @PutMapping("/{exerciseSetId}")
    @Operation(summary = "Update exercise set", description = "Updates exercise set by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise set updated"),
            @ApiResponse(responseCode = "400", description = "Invalid exercise set update",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Exercise set not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Set type not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateExerciseSet(@PathVariable Integer exerciseSetId, @Valid @RequestBody ExerciseSetUpdate exerciseSetUpdate) {
        exerciseSetService.updateExerciseSet(exerciseSetId, exerciseSetUpdate);
    }

    @DeleteMapping("/{exerciseSetId}")
    @Operation(summary = "Delete exercise set by id", description = "Deletes exercise set by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise set deleted"),
            @ApiResponse(responseCode = "404", description = "Exercise set not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void deleteExerciseSet(@PathVariable Integer exerciseSetId) {
        exerciseSetService.deleteExerciseSet(exerciseSetId);
    }


}
