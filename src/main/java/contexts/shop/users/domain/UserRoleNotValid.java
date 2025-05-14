package contexts.shop.users.domain;

public class UserRoleNotValid extends RuntimeException {
  public UserRoleNotValid(String message) {
    super(message);
  }
}
