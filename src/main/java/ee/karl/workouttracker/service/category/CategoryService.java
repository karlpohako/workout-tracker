package ee.karl.workouttracker.service.category;

import ee.karl.workouttracker.controller.category.dto.CategoryDto;
import ee.karl.workouttracker.controller.category.dto.CategoryInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataInUseException;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.infrastructure.rest.exception.DatabaseNameConflictException;
import ee.karl.workouttracker.presistence.category.Category;
import ee.karl.workouttracker.presistence.category.CategoryMapper;
import ee.karl.workouttracker.presistence.category.CategoryRepository;
import ee.karl.workouttracker.presistence.exercise.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ExerciseRepository exerciseRepository;

    public void saveCategory(CategoryDto categoryDto) {
        Category category = createCategory(categoryDto);
        categoryRepository.save(category);
    }

    public CategoryDto findCategoryById(Integer categoryId) {
        Category category = getCategoryBy(categoryId);
        return categoryMapper.toCategoryDto(category);
    }

    public List<CategoryInfo> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toCategoryInfoDtos(categories);
    }

    public void updateCategory(Integer categoryId, CategoryDto categoryDto) {
        Category category = getCategoryBy(categoryId);
        categoryMapper.updateCategoryFromTo(categoryDto, category);
        categoryRepository.save(category);
    }

    public void deleteCategoryBy(Integer categoryId) {
        assertExistsAndNotInUseBy(categoryId);
        categoryRepository.deleteById(categoryId);
    }

    private void assertExistsAndNotInUseBy(Integer categoryId) {
        boolean categoryExists = categoryRepository.existsById(categoryId);
        if (!categoryExists) {
            throw new DataNotFoundException(Error.CATEGORY_NOT_FOUND.getMessage());
        }
        boolean categoryInUse = exerciseRepository.isCategoryUsedInExercisesBy(categoryId);
        if (categoryInUse) {
            throw new DataInUseException(Error.CATEGORY_IN_USE.getMessage());
        }
    }

    private Category getCategoryBy(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new DataNotFoundException(Error.CATEGORY_NOT_FOUND.getMessage()));
    }

    private Category createCategory(CategoryDto categoryDto) {
        boolean exists = categoryRepository.existsByName(categoryDto.getName());
        if (exists) {
            throw new DatabaseNameConflictException(Error.CATEGORY_ALREADY_EXISTS.getMessage());
        }
        return categoryMapper.toCategory(categoryDto);
    }
}
