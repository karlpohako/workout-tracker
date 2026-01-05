package ee.karl.workouttracker.controller.equipmenttype.dto;

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
public class EquipmentTypeDto implements Serializable {

    @NotNull
    @Size(max = 100)
    @NotBlank
    private String name;
}