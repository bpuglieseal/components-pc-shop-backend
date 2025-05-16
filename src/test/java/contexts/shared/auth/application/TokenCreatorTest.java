package contexts.shared.auth.application;

import com.componentsshop.apps.backend.ComponentsShopBackendApplication;
import contexts.shared.auth.infrastructure.TokenProvider;
import static org.mockito.Mockito.*;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = ComponentsShopBackendApplication.class)
class TokenCreatorTest {
    @Mock
    private TokenProvider provider;

    @InjectMocks
    private TokenCreator creator;

    @Test
    @Label("token creator should call the provider")
    void tokenCreatorShouldCallTheProvider() {
        String payload = UUID.randomUUID().toString();
        when(this.provider.encodeJWT(payload)).thenReturn("some-jwt");

        String token = this.creator.run(payload);

        assertNotNull(token);
        verify(this.provider, times(1)).encodeJWT(payload);
    }
}