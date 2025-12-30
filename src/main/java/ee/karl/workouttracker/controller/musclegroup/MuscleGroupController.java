package ee.karl.workouttracker.controller.musclegroup;

import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupDto;
import ee.karl.workouttracker.controller.musclegroup.dto.MuscleGroupInfo;
import ee.karl.workouttracker.service.musclegroup.MuscleGroupService;
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
@RequestMapping("/musclegroup")
public class MuscleGroupController {

    private final MuscleGroupService muscleGroupService;

    @PostMapping("/create")
    @Operation(summary = "Create a new muscle group", description = "Create a new muscle group with the provided information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Muscle group created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid muscle group information",
                    content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "409", description = "Muscle group already exists",
                    content = @Content(schema = @Schema(implementation = Error.class)))

    })
    public void createMuscleGroup(@RequestBody @Valid MuscleGroupDto muscleGroupDto) {
        muscleGroupService.saveMuscleGroup(muscleGroupDto);
    }

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
            @ApiResponse(responseCode = "404", description = "Muscle group not found",
                    content = @Content(schema = @Schema(implementation = Error.class)))
    })
    public MuscleGroupDto getMuscleGroupById(@PathVariable Integer muscleGroupId) {
        return muscleGroupService.findMuscleGroupById(muscleGroupId);
    }

    @PutMapping("/{muscleGroupId}")
    @Operation(summary = "Update muscle group by ID", description = "Update a muscle group by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Muscle group updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid muscle group information",
                    content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "404", description = "Muscle group not found",
                    content = @Content(schema = @Schema(implementation = Error.class)))
    })
    public void updateMuscleGroup(@PathVariable Integer muscleGroupId, @Valid @RequestBody MuscleGroupDto muscleGroupDto) {
        muscleGroupService.updateMuscleGroup(muscleGroupId, muscleGroupDto);
    }
}
