package contexts.shop.users.domain;

import java.time.LocalDate;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private UserEmail email;
    private String password;
    private String direction;
    private UserBirthdate birthdate;
    private UserRole role;

    public User(int id, String name, UserEmail email, String password, String direction, UserBirthdate birthdate, UserRole role) {
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

    public UserEmail getEmail() {
        return email;
    }

    public void setEmail(UserEmail email) {
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

    public UserBirthdate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(UserBirthdate birthdate) {
        this.birthdate = birthdate;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public static User fromPrimitivesToDomain(int id, String name, String email, String password, String direction, LocalDate birthdate, String role) {
        return new User(id, name, new UserEmail(email), password, direction, new UserBirthdate(birthdate), new UserRole(role));
    }
}
