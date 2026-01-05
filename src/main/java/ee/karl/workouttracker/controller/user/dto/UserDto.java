package ee.karl.workouttracker.controller.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
