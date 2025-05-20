package contexts.shop.users.application.finder;

import contexts.shop.users.domain.User;
import contexts.shop.users.domain.UserEmail;
import contexts.shop.users.infrastructure.persistence.UserJPAEntity;
import contexts.shop.users.infrastructure.persistence.UserJPARepository;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserFinderTest {
    @Mock
    private UserJPARepository repository;

    @InjectMocks
    private UserFinder finder;

    @Test
    @Label("User finder should execute repository service and return an user domain entity")
    void userFinderShouldExecuteRepositoryService() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate userBirthdate = LocalDate.parse("14/05/2005", formatter);
        String email = "ana.martinez@mail.com";

        UserJPAEntity userEntity = new UserJPAEntity(1, "Ana Martinez","ana.martinez@mail.com", "Pass1234!", "Calle 12 #45-67, Madrid", userBirthdate, "USER");

        UserEmail userEmail = new UserEmail(email);
        UserFinderRequest request = new UserFinderRequest(userEmail);

        when(this.repository.findByEmail(email)).thenReturn(Optional.of(userEntity));
        Optional<UserFinderResponse> response = this.finder.run(request);

        response.ifPresent(userFinderResponse -> {
            User foundedUser = userFinderResponse.getUser();
            assertNotNull(foundedUser);
            assertInstanceOf(User.class, foundedUser);
            verify(repository, times(1)).findByEmail(email);
        });
    }

    @Test
    @Label("Should return an empty optional if user not exists")
    void userFinderShouldReturnAnEmptyOptionalIfUserNotExists () {
        String email = "ana.martinez@mail.com";

        UserEmail userEmail = new UserEmail(email);
        UserFinderRequest request = new UserFinderRequest(userEmail);

        when(this.repository.findByEmail(email)).thenReturn(Optional.empty());
        Optional<UserFinderResponse> response = this.finder.run(request);

        assertTrue(response.isEmpty());
        verify(repository, times(1)).findByEmail(email);
    }
}