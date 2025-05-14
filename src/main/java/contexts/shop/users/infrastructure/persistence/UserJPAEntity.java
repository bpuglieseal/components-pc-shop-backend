package contexts.shop.users.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class UserJPAEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;
    private String direction;
    private LocalDate birthdate;
    private String role;
}
