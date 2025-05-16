package contexts.shared.auth.application;

import com.componentsshop.apps.backend.ComponentsShopBackendApplication;
import com.github.javafaker.Faker;
import contexts.shared.auth.infrastructure.TokenProvider;
import static org.mockito.Mockito.*;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = ComponentsShopBackendApplication.class)
class TokenValidatorTest {
    @Mock
    private TokenProvider provider;

    @InjectMocks
    private TokenValidator validator;

    @Test
    @Label("token creator should call the provider")
    void tokenCreatorShouldCallTheProvider() {
        Faker faker = new Faker();
        String token = faker.lorem().characters(1);
        when(this.provider.decodeJWT(token)).thenReturn("some-payload");

        String payload = this.validator.run(token);

        assertNotNull(payload);
        verify(this.provider, times(1)).decodeJWT(token);
    }
}