package contexts.shop.users.domain;

public class UserEmail {
    private String email;

    public UserEmail(String email) {
        this.email = email;
        this.ensureEmailIsValid();
    }

    private void ensureEmailIsValid() {
        String emailRegex = "^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$";
        if (this.email.isEmpty() || !this.email.matches(emailRegex)) {
            throw new UserEmailNotValid(String.format("The email %s is not valid", email));
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
