package ee.karl.workouttracker.controller.category;

import ee.karl.workouttracker.controller.category.dto.CategoryDto;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.category.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Find category by id", description = "Returns category by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns category by id"),
            @ApiResponse(responseCode = "404", description = "If category with given id doesn't exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public CategoryDto findCategoryById(@PathVariable Integer categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

}
