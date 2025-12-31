package ee.karl.workouttracker.controller.settype.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SetTypeDto implements Serializable {

    @NotNull
    @Size(max = 100)
    String name;
}