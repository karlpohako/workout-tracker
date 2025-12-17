package ee.karl.workouttracker.controller.category;

import ee.karl.workouttracker.controller.category.dto.CategoryDto;
import ee.karl.workouttracker.controller.category.dto.CategoryInfo;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.category.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    @Operation(summary = "Create new category", description = "Creates new category and adds it to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Creates new category and adds it to database"),
            @ApiResponse(responseCode = "400", description = "If categoryDto is invalid",
            content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "If category already exists",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void createCategory(@RequestBody @Valid CategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);
    }

    @GetMapping("/{categoryId}")
    @Operation(summary = "Find category by id", description = "Returns category by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns category by id"),
            @ApiResponse(responseCode = "404", description = "If category with given id doesn't exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public CategoryDto findCategoryById(@PathVariable Integer categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @GetMapping("/categories")
    @Operation(summary = "Find all categories", description = "Returns all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all categories")
    })
    public List<CategoryInfo> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @PutMapping("/{categoryId}")
    @Operation(summary = "Update category by id", description = "Updates category with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updates category with given id"),
            @ApiResponse(description = "If categoryDto is invalid", responseCode = "400",
            content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(description = "If category with given id doesn't exist", responseCode = "404",
            content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateCategory(@PathVariable Integer categoryId, @RequestBody @Valid CategoryDto categoryDto) {
        categoryService.updateCategory(categoryId, categoryDto);
    }
}
