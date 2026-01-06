package ee.karl.workouttracker.controller.user;

import ee.karl.workouttracker.controller.user.dto.*;
import ee.karl.workouttracker.infrastructure.rest.error.ApiError;
import ee.karl.workouttracker.service.user.UserService;
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
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    @Operation(summary = "Create new user", description = "Creates new user and adds it to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid user data provided",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "User with this username already exists",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void createUser(@RequestBody @Valid UserCreationDto userCreationDto) {
        userService.saveUser(userCreationDto);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Find user by id", description = "Returns user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found successfully"),
            @ApiResponse(responseCode = "404", description = "User with the specified ID not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public UserDto findUserById(@PathVariable Integer userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/users")
    @Operation(summary = "Find all users", description = "Returns all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    })
    public List<UserInfo> findAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping("/{userId}/email")
    @Operation(summary = "Update user email by id", description = "Updates user email with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid email data provided",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "User with the specified ID not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateUserEmail(@PathVariable Integer userId, @RequestBody @Valid EmailUpdateDto emailUpdateDto) {
        userService.updateUserEmail(userId, emailUpdateDto);
    }

    @PutMapping("/{userId}/password")
    @Operation(summary = "Update user password by id", description = "Updates user password with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Password updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid password data provided",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "User with the specified ID not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void updateUserPassword(@PathVariable Integer userId, @RequestBody @Valid PasswordUpdateDto passwordUpdateDto) {
        userService.updateUserPassword(userId, passwordUpdateDto);
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Delete user by id", description = "Deletes user with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User with the specified ID not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}