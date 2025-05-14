package contexts.shop.users.domain;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String direction;
    private UserBirthdate birthdate;
    private UserRole role;

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

    public User(int id, String name, String email, String password, String direction, Date birthdate, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.direction = direction;
        this.birthdate = new UserBirthdate(birthdate);
        this.role = new UserRole(role);
    }

}
