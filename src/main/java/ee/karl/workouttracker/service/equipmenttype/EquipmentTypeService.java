package ee.karl.workouttracker.service.equipmenttype;

import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeDto;
import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.infrastructure.rest.exception.DatabaseNameConflictException;
import ee.karl.workouttracker.presistence.equipmenttype.EquipmentType;
import ee.karl.workouttracker.presistence.equipmenttype.EquipmentTypeMapper;
import ee.karl.workouttracker.presistence.equipmenttype.EquipmentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentTypeService {

    private final EquipmentTypeRepository equipmentTypeRepository;
    private final EquipmentTypeMapper equipmentTypeMapper;

    public void saveEquipmentType(EquipmentTypeDto equipmentTypeDto) {
        EquipmentType equipmentType = createEquipmentType(equipmentTypeDto);
        equipmentTypeRepository.save(equipmentType);
    }

    public EquipmentTypeDto findEquipmentTypeById(Integer equipmentTypeId) {
        EquipmentType equipmentType = getEquipmentType(equipmentTypeId);
        return equipmentTypeMapper.toEquipmentTypeDto(equipmentType);
    }

    public List<EquipmentTypeInfo> findAllEquipmentTypes() {
        List<EquipmentType> equipmentTypes = equipmentTypeRepository.findAll();
        return equipmentTypeMapper.toEquipmentTypeInfos(equipmentTypes);
    }

    private EquipmentType createEquipmentType(EquipmentTypeDto equipmentTypeDto) {
        boolean exists = equipmentTypeRepository.existsByName(equipmentTypeDto.getName());
        if (exists) {
            throw new DatabaseNameConflictException(Error.EQUIPMENT_TYPE_ALREADY_EXISTS.getMessage());
        }
        return equipmentTypeMapper.toEquipmentType(equipmentTypeDto);
    }

    private EquipmentType getEquipmentType(Integer equipmentTypeId) {
        return equipmentTypeRepository.findById(equipmentTypeId).
                orElseThrow(() -> new DataNotFoundException(Error.EQUIPMENT_TYPE_NOT_FOUND.getMessage()));
    }
}
