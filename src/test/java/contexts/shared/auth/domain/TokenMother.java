package contexts.shared.auth.domain;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.javafaker.Faker;
import contexts.shared.auth.infrastructure.TokenConfiguration;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class TokenMother {
    private final TokenConfiguration tokenConfiguration;
    private final Faker faker;

    TokenMother(TokenConfiguration tokenConfiguration) {
        this.tokenConfiguration = tokenConfiguration;
        this.faker = new Faker();
    }

    public String withExpiredTime (String payload) {
        byte[] decodedSecret = Base64.getDecoder().decode(this.tokenConfiguration.getSecret());
        Algorithm algorithm = Algorithm.HMAC256(decodedSecret);

        return JWT.create()
                .withSubject(payload)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() - 100000))
                .sign(algorithm);
    }

    public String withInvalidSignature (String payload) {
        String secret = this.faker.lorem().word();
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(payload)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + this.tokenConfiguration.getDuration()))
                .sign(algorithm);
    }
}
