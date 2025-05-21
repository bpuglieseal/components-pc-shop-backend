package contexts.shop.users.application.finder;

import contexts.shop.users.domain.User;
import contexts.shop.users.infrastructure.persistence.UserJPAEntity;
import contexts.shop.users.infrastructure.persistence.UserJPARepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserFinder {
    private final UserJPARepository repository;

    public UserFinder(UserJPARepository repository) {
        this.repository = repository;
    }

    public Optional<UserFinderResponse> run (UserFinderRequest request) {
        String email = request.getEmail();
        Optional<UserJPAEntity> result = this.repository.findByEmail(email);

        if (result.isPresent()) {
            UserJPAEntity entity = result.get();
            User user = User.fromPrimitivesToDomain(entity.getId(), entity.getName(), entity.getEmail(), entity.getPassword(), entity.getDirection(), entity.getBirthdate(), entity.getRole());
            return Optional.of(new UserFinderResponse(user));
        } else {
            return Optional.empty();
        }
    }
}
