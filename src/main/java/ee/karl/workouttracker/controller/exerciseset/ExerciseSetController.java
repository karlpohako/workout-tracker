package ee.karl.workouttracker.controller.exerciseset;

import ee.karl.workouttracker.controller.exerciseset.dto.ExerciseSetDto;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.exerciseset.ExerciseSetService;
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
@RequestMapping("/exerciseset")
@RequiredArgsConstructor
class ExerciseSetController {

    private final ExerciseSetService exerciseSetService;

    @GetMapping("/{exerciseSet}")
    @Operation(summary = "Get exercise set by id", description = "Returns exercise set by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise set found"),
            @ApiResponse(responseCode = "404", description = "Exercise set not found",
            content = @Content (schema = @Schema(implementation = ApiError.class)))
    })
    public ExerciseSetDto getExerciseSet(@PathVariable Integer exerciseSet) {
       return exerciseSetService.findExerciseSetById(exerciseSet);
    }

}
