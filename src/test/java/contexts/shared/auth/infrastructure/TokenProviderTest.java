package contexts.shared.auth.infrastructure;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.componentsshop.apps.backend.ComponentsShopBackendApplication;
import contexts.shared.auth.domain.TokenMother;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

@SpringBootTest(classes = ComponentsShopBackendApplication.class)
class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private TokenMother tokenMother;

    @Test
    @Label("provider should throw the token expired exception")
    void shouldThrowAnTokenExpiredException() {
        String uuid = UUID.randomUUID().toString();
        String token = this.tokenMother.withExpiredTime(uuid);
        assertThrows(TokenExpiredException.class, () -> this.tokenProvider.decodeJWT(token));
    }

    @Test
    @Label("provider should throw an invalid signature token exception")
    void shouldThrowAnInvalidTokenException() {
        String uuid = UUID.randomUUID().toString();
        String token = this.tokenMother.withInvalidSignature(uuid);
        assertThrows(SignatureVerificationException.class, () -> this.tokenProvider.decodeJWT(token));
    }

    @Test
    @Label("provider should create a valid token")
    void shouldCreateAValidToken() {
        String uuid = UUID.randomUUID().toString();
        String token = this.tokenProvider.encodeJWT(uuid);

        assertNotNull(token);
        assertDoesNotThrow(() -> this.tokenProvider.decodeJWT(token));
    }

    @Test
    @Label("provider decoder should create a valid token and return the expected data on decode")
    void shouldCreateAValidTokenAndReturnTheExpectedData() {
        String uuid = UUID.randomUUID().toString();
        String token = this.tokenProvider.encodeJWT(uuid);

        String decoded = this.tokenProvider.decodeJWT(token);
        assertNotNull(decoded);
        assertEquals(uuid, decoded);
    }
}