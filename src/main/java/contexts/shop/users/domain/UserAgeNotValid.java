package contexts.shop.users.domain;

public class UserAgeNotValid extends RuntimeException {
    public UserAgeNotValid(String message) {
        super(message);
    }
}
