package ee.karl.workouttracker.presistence.equipmenttype;

import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EquipmentTypeMapper {
    @Mapping(target = "name", source = "name")
    EquipmentTypeDto toEquipmentTypeDto(EquipmentType equipmentType);

    @Mapping(target = "name", source = "name")
    EquipmentType toEquipmentType(EquipmentTypeDto equipmentTypeDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EquipmentType updateEquipmentType(EquipmentTypeDto equipmentTypeDto, @MappingTarget EquipmentType equipmentType);
}