package ee.karl.workouttracker.controller.settype;

import ee.karl.workouttracker.controller.settype.dto.SetTypeDto;
import ee.karl.workouttracker.controller.settype.dto.SetTypeInfo;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.settype.SetTypeService;
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
@RequestMapping("/settype")
public class SetTypeController {

    private final SetTypeService setTypeService;

    @PostMapping("/create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Creates new set type"),
            @ApiResponse(responseCode = "400", description = "Invalid set type data",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "Set type with same name already exists",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void createSetType(@RequestBody SetTypeDto setTypeDto) {
        setTypeService.saveSetType(setTypeDto);
    }

    @GetMapping("/settypes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all set types")
    })
    public List<SetTypeInfo> getAllSetTypes() {
        return setTypeService.findAllSetTypes();
    }

    @GetMapping("/{setTypeId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns set type by id"),
            @ApiResponse(responseCode = "404", description = "Set type not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public SetTypeDto getSetTypeById(@PathVariable Integer setTypeId) {
        return setTypeService.findSetTypeById(setTypeId);
    }

    @PutMapping("/{setTypeId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Set type updated"),
            @ApiResponse(responseCode = "400", description = "Invalid set type data",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Set type not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateSetType(@PathVariable Integer setTypeId, @Valid @RequestBody SetTypeDto setTypeDto) {
        setTypeService.updateSetType(setTypeId, setTypeDto);
    }

    @DeleteMapping("/{setTypeId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Set type deleted"),
            @ApiResponse(responseCode = "404", description = "Set type not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "Set type is used in exercise sets",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void deleteSetType(@PathVariable Integer setTypeId) {
        setTypeService.deleteSetType(setTypeId);
    }
}
