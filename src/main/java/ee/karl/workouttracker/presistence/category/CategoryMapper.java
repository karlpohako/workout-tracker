package ee.karl.workouttracker.presistence.category;

import ee.karl.workouttracker.controller.category.dto.CategoryDto;
import ee.karl.workouttracker.controller.category.dto.CategoryInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    @Mapping(target = "name", source = "name")
    CategoryDto toCategoryDto(Category category);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CategoryInfo toCategoryInfoDto(Category category);

    List<CategoryInfo> toCategoryInfoDtos(List<Category> categories);
}
