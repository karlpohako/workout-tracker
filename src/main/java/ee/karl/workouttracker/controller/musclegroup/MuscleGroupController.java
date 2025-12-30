package ee.karl.workouttracker.controller.musclegroup;

import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupInfo;
import ee.karl.workouttracker.service.musclegroup.MuscleGroupService;
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
@RequestMapping("/musclegroup")
public class MuscleGroupController {

    private final MuscleGroupService muscleGroupService;

    @GetMapping("/musclegroups")
    @Operation(summary = "Get all muscle groups", description = "Retrieve a list of all muscle groups")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a list of all muscle groups")
    })
    public List<MuscleGroupInfo> getAllMuscleGroups() {
        return muscleGroupService.findAllMuscleGroups();
    }
}
