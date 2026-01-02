package ee.karl.workouttracker.controller.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDto implements Serializable {

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String username;

    @NotBlank
    @NotNull
    @Email
    @Size(max = 100)
    private String email;

}
