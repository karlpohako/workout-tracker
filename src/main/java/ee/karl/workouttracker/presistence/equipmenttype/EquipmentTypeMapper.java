package ee.karl.workouttracker.presistence.equipmenttype;

import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeDto;
import ee.karl.workouttracker.controller.equipmenttype.dto.EquipmentTypeInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EquipmentTypeMapper {
    @Mapping(target = "name", source = "name")
    EquipmentTypeDto toEquipmentTypeDto(EquipmentType equipmentType);

    @Mapping(target = "name", source = "name")
    EquipmentType toEquipmentType(EquipmentTypeDto equipmentTypeDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @InheritConfiguration(name = "toEquipmentType")
    EquipmentType updateEquipmentType(EquipmentTypeDto equipmentTypeDto, @MappingTarget EquipmentType equipmentType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @InheritConfiguration(name = "toEquipmentTypeDto")
    @Mapping(target = "id", source = "id")
    EquipmentTypeInfo toEquipmentTypeInfo(EquipmentType equipmentType);

    List<EquipmentTypeInfo> toEquipmentTypeInfos(List<EquipmentType> equipmentTypes);
}