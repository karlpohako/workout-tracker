package ee.karl.workouttracker.controller.musclegroup;

import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupDto;
import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupInfo;
import ee.karl.workouttracker.service.musclegroup.MuscleGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{muscleGroupId}")
    @Operation(summary = "Get muscle group by ID", description = "Retrieve a muscle group by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns the muscle group with the specified ID"),
            @ApiResponse(responseCode = "404", description = "Muscle group not found")
    })
    public MuscleGroupDto getMuscleGroupById(@PathVariable Integer muscleGroupId) {
        return muscleGroupService.findMuscleGroupById(muscleGroupId);
    }
}
