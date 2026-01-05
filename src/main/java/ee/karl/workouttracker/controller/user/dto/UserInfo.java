package ee.karl.workouttracker.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends UserDto implements Serializable {

    private Integer id;
    private Instant createdAt;
    private Instant updatedAt;

}
