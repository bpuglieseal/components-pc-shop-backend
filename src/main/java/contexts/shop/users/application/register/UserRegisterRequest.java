package contexts.shop.users.application.register;

import java.time.LocalDate;

public class UserRegisterRequest {
    private String username;
    private String password;
    private String email;
    private String direction;
    private LocalDate dateOfBirth;

    public UserRegisterRequest(String username, String password, String email, String direction, LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.direction = direction;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
