package ee.karl.workouttracker.controller.equipmenttype;

import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeDto;
import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeInfo;
import ee.karl.workouttracker.service.equipmenttype.EquipmentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipmenttype")
@RequiredArgsConstructor
public class EquipmentTypeController {

    private final EquipmentTypeService equipmentTypeService;

    @GetMapping("/{equipmentTypeId}")
    @Operation(summary = "Find equipment type by id", description = "Finds equipment type by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns equipment type with given id"),
            @ApiResponse(responseCode = "404", description = "If equipment type with given id doesn't exist")
    })
    public EquipmentTypeDto findEquipmentTypeById(@PathVariable Integer equipmentTypeId) {
        return equipmentTypeService.findEquipmentTypeById(equipmentTypeId);
    }

    @GetMapping("/equipmenttypes")
    @Operation(summary = "Find all equipment types", description = "Returns all equipment types")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all equipment types")
    })
    public List<EquipmentTypeInfo> findAllEquipmentTypes(){
        return equipmentTypeService.findAllEquipmentTypes();
    }
}
