package ee.karl.workouttracker.controller.exercise;

import ee.karl.workouttracker.controller.exercise.dto.ExerciseDto;
import ee.karl.workouttracker.controller.exercise.dto.ExerciseInfoDto;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.exercise.ExerciseService;
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
@RequestMapping("/")
@RequiredArgsConstructor
class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping("/exercise")
    @Operation(summary = "Add new exercise", description = "Creates new exercise and adds it to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Creates new exercise and adds it to database"),
            @ApiResponse(responseCode = "400", description = "If exerciseDto is invalid",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "If category, muscle group or equipment type is not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "If exercise already exists",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void addExercise(@RequestBody @Valid ExerciseDto exerciseDto) {
        exerciseService.addExercise(exerciseDto);
    }

    @GetMapping("/exercise/{exerciseId}")
    @Operation(summary = "Finds exercise by id", description = "Returns exercise with given id, if exercise doesn't exist throws an error")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns exercise with given id"),
            @ApiResponse(responseCode = "404", description = "If exercise with given id doesn't exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public ExerciseDto findExercise(@PathVariable Integer exerciseId) {
        return exerciseService.findExercise(exerciseId);
    }

    @GetMapping("/exercises")
    @Operation(summary = "Finds all exercises", description = "Returns all exercises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all exercises")
    })
    public List<ExerciseInfoDto> findAllExercises() {
        return exerciseService.findAllExercises();
    }

    @PutMapping("/exercise/{exerciseId}")
    @Operation(summary = "Updates exercise by id", description = "Updates exercise with given id, if dto fields are valid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updates exercise"),
            @ApiResponse(description = "If exerciseDto is invalid", responseCode = "400",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(description = "If exercise, category, muscle group or equipment type is not found", responseCode = "404",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateExercise(@PathVariable Integer exerciseId, @RequestBody @Valid ExerciseDto exerciseDto) {
        exerciseService.updateExercise(exerciseId, exerciseDto);
    }

    @DeleteMapping("/exercise/{exerciseId}")
    @Operation(summary = "Deletes exercise by id", description = "Deletes exercise with given id if exercise is not used in workout")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletes exercise"),
            @ApiResponse(responseCode = "409", description = "Exercise is used in workout",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void deleteExercise(@PathVariable Integer exerciseId) {
        exerciseService.deleteExercise(exerciseId);
    }
}
