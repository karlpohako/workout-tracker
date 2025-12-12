package ee.karl.workouttracker.controller.exercise;

import ee.karl.workouttracker.controller.exercise.dto.ExerciseDto;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.exercise.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
class ExerciseController {

    private final ExerciseService exerciseService;

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

}
