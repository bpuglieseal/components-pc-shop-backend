package contexts.shop.users.application.login;

import contexts.shared.auth.application.TokenCreator;
import contexts.shop.users.application.finder.UserFinder;
import contexts.shop.users.application.finder.UserFinderRequest;
import contexts.shop.users.application.finder.UserFinderResponse;
import contexts.shop.users.domain.User;
import contexts.shop.users.domain.UserEmail;
import contexts.shop.users.domain.UserNotExists;
import contexts.shop.users.domain.UserWrongCredentials;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLogin {
    private final UserFinder finder;
    private final TokenCreator creator;
    private final BCryptPasswordEncoder encoder;

    UserLogin(final UserFinder finder, final TokenCreator creator, final BCryptPasswordEncoder encoder) {
        this.finder = finder;
        this.creator = creator;
        this.encoder = encoder;
    }

    private void ensureUserExists(final String userEmail) {
        UserEmail email = new UserEmail(userEmail);
        UserFinderRequest request = new UserFinderRequest(email);

        Optional<UserFinderResponse> response = this.finder.run(request);
        if (response.isEmpty()) {
            throw new UserNotExists(String.format("User %s not found", userEmail));
        }
    }

    private void ensureCredentialsAreValid(final String password, final String passwordToCompare) {
        if (!encoder.matches(passwordToCompare, password)) {
            throw new UserWrongCredentials(String.format("Wrong password: %s", passwordToCompare));
        }
    }

    public UserLoginResponse run(UserLoginRequest request) {
        this.ensureUserExists(request.getUsername());

        String username = request.getUsername();
        String password = request.getPassword();

        Optional<UserFinderResponse> response = this.finder.run(new UserFinderRequest(new UserEmail(username)));
        User user = response.get().getUser();

        this.ensureCredentialsAreValid(user.getPassword(), password);

        String token = this.creator.run(password);
        return new UserLoginResponse(token);
    }
}
