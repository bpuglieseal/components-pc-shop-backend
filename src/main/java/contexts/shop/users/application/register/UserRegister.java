package contexts.shop.users.application.register;

import contexts.shared.auth.application.TokenCreator;
import contexts.shop.users.application.finder.UserFinder;
import contexts.shop.users.application.finder.UserFinderRequest;
import contexts.shop.users.application.finder.UserFinderResponse;
import contexts.shop.users.domain.UserAlreadyExists;
import contexts.shop.users.domain.UserEmail;
import contexts.shop.users.infrastructure.persistence.UserJPAEntity;
import contexts.shop.users.infrastructure.persistence.UserJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegister {
    private final UserJPARepository repository;
    private final UserFinder finder;
    private final TokenCreator tokenCreator;

    UserRegister(UserJPARepository repository, UserFinder finder, TokenCreator tokenCreator) {
        this.repository = repository;
        this.finder = finder;
        this.tokenCreator = tokenCreator;
    }

    private void ensureUserDoesNotExist(String email) {
        UserEmail userEmail = new UserEmail(email);
        Optional<UserFinderResponse> response = this.finder.run(new UserFinderRequest(userEmail));

        if (response.isPresent()) {
            throw new UserAlreadyExists(String.format("User with email %s already exists", email));
        }
    }

    public UserRegisterResponse run (UserRegisterRequest request) {
        this.ensureUserDoesNotExist(request.getEmail());

        UserJPAEntity userToCreate = new UserJPAEntity(request.getUsername(), request.getEmail(), request.getPassword(), request.getDirection(), request.getDateOfBirth(),  "USER");
        UserJPAEntity userCreated = this.repository.save(userToCreate);

        String payload = userCreated.getEmail();
        String token = this.tokenCreator.run(payload);

        return new UserRegisterResponse(token);
    }
}
