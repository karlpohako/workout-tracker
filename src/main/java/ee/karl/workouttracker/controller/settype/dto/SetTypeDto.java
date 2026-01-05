package ee.karl.workouttracker.controller.settype.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetTypeDto implements Serializable {

    @NotNull
    @Size(max = 100)
    String name;
}