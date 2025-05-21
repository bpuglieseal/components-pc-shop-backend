package contexts.shop.users.application.finder;

import contexts.shop.users.domain.User;

public class UserFinderResponse {
    public User user;

    public UserFinderResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
