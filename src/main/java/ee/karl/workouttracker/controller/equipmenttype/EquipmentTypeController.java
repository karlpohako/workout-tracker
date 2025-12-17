package ee.karl.workouttracker.controller.equipmenttype;

import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeDto;
import ee.karl.workouttracker.service.equipmenttype.EquipmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipmenttype")
@RequiredArgsConstructor
public class EquipmentTypeController {

    private final EquipmentTypeService equipmentTypeService;

    @GetMapping("/{equipmentTypeId}")
    public EquipmentTypeDto findEquipmentTypeById(@PathVariable Integer equipmentTypeId) {
        return equipmentTypeService.findEquipmentTypeById(equipmentTypeId);
    }
}
