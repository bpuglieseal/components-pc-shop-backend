package contexts.shop.users.infrastructure.persistence;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserJPAEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String direction;
    private LocalDate birthdate;
    private String role;

    public UserJPAEntity(String username, String email, String password, String direction, LocalDate dateOfBirth, String role) {
        this.name = username;
        this.email = email;
        this.password = password;
        this.direction = direction;
        this.birthdate = dateOfBirth;
        this.role = role;
    }

    public UserJPAEntity() {

    }

    public UserJPAEntity(int id, String name, String email, String password, String direction, LocalDate birthdate, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.direction = direction;
        this.birthdate = birthdate;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
