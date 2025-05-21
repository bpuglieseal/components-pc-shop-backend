package contexts.shop.users.domain;

public class UserNotExists extends RuntimeException {
    public UserNotExists(String message) {
        super(message);
    }
}
