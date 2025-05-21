package contexts.shop.users.application.finder;

import contexts.shop.users.domain.UserEmail;

public class UserFinderRequest {
    private final UserEmail email;

    public UserFinderRequest(UserEmail email) {
        this.email = email;
    }

    public String getEmail() {
        return email.getEmail();
    }
}
