package ee.karl.workouttracker.presistence.category;

import ee.karl.workouttracker.controller.category.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    @Mapping(target = "name", source = "name")
    CategoryDto toCategoryDto(Category category);
}
