package contexts.shop.users.domain;

public class UserWrongCredentials extends RuntimeException {
    public UserWrongCredentials(String message) {
        super(message);
    }
}
