package contexts.shop.users.domain;

public class UserEmailNotValid extends RuntimeException {
  public UserEmailNotValid(String message) {
    super(message);
  }
}
