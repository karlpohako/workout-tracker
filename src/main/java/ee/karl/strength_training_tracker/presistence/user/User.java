package ee.karl.strength_training_tracker.presistence.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "USERNAME", nullable = false, length = 50)
    private String username;

    @Size(max = 100)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    private Instant createdAt;

    @NotNull
    @Column(name = "UPDATED_AT", nullable = false)
    private Instant updatedAt;


}