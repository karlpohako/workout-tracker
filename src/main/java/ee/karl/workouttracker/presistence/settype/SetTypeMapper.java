package ee.karl.workouttracker.presistence.settype;

import ee.karl.workouttracker.controller.settype.dto.SetTypeDto;
import ee.karl.workouttracker.controller.settype.dto.SetTypeInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SetTypeMapper {

    @Mapping(target = "name", source = "name")
    SetType toEntity(SetTypeDto setTypeDto);

    @Mapping(target = "name", source = "name")
    SetTypeDto toDto(SetType setType);

    @Mapping(target = "name", source = "name")
    SetTypeInfo toInfoDto(SetType setType);

    List<SetTypeInfo> toInfoDtos(List<SetType> setTypes);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SetType updateSetType(SetTypeDto setTypeDto, @MappingTarget SetType setType);
}