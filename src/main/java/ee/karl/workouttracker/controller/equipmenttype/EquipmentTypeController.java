package ee.karl.workouttracker.controller.equipmenttype;

import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeDto;
import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeInfo;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.equipmenttype.EquipmentTypeService;
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
@RequestMapping("/equipmenttype")
@RequiredArgsConstructor
public class EquipmentTypeController {

    private final EquipmentTypeService equipmentTypeService;

    @PostMapping("/create")
    @Operation(summary = "Create new equipment type", description = "Creates new equipment type and adds it to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Creates new equipment type and adds it to database"),
            @ApiResponse(responseCode = "400", description = "If equipmentTypeDto is invalid",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "Equipment type already exists",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void createEquipmentType(@RequestBody @Valid EquipmentTypeDto equipmentTypeDto) {
        equipmentTypeService.saveEquipmentType(equipmentTypeDto);
    }

    @GetMapping("/{equipmentTypeId}")
    @Operation(summary = "Find equipment type by id", description = "Finds equipment type by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns equipment type with given id"),
            @ApiResponse(responseCode = "404", description = "If equipment type with given id doesn't exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public EquipmentTypeDto findEquipmentTypeById(@PathVariable Integer equipmentTypeId) {
        return equipmentTypeService.findEquipmentTypeById(equipmentTypeId);
    }

    @GetMapping("/equipmenttypes")
    @Operation(summary = "Find all equipment types", description = "Returns all equipment types")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all equipment types")
    })
    public List<EquipmentTypeInfo> findAllEquipmentTypes() {
        return equipmentTypeService.findAllEquipmentTypes();
    }

    @PutMapping("/{equipmentTypeId}")
    @Operation(summary = "Update equipment type", description = "Updates equipment type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns updated equipment type"),
            @ApiResponse(description = "If equipmentTypeInfo is invalid", responseCode = "400",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "If equipment type with given id doesn't exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateEquipmentType(@PathVariable Integer equipmentTypeId, @RequestBody @Valid EquipmentTypeDto equipmentTypeDto) {
        equipmentTypeService.updateEquipmentType(equipmentTypeId, equipmentTypeDto);
    }
}
