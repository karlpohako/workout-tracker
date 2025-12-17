package ee.karl.workouttracker.controller.equipmenttype.dto;

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
public class EquipmentTypeDto implements Serializable {

    @NotNull
    @Size(max = 100)
    @NotBlank
    private String name;
}