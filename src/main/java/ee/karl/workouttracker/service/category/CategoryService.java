package ee.karl.workouttracker.service.category;

import ee.karl.workouttracker.controller.category.dto.CategoryDto;
import ee.karl.workouttracker.controller.category.dto.CategoryInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.category.Category;
import ee.karl.workouttracker.presistence.category.CategoryMapper;
import ee.karl.workouttracker.presistence.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto findCategoryById(Integer categoryId) {
        Category category = getCategoryBy(categoryId);
        return categoryMapper.toCategoryDto(category);
    }

    private Category getCategoryBy(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new DataNotFoundException(Error.CATEGORY_NOT_FOUND.getMessage()));
    }

    public List<CategoryInfo> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toCategoryInfoDtos(categories);
    }
}
