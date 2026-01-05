package ee.karl.workouttracker.controller.equipmenttype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EquipmentTypeInfo extends EquipmentTypeDto implements Serializable {

    private Integer id;
}