package contexts.shared.auth.infrastructure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import contexts.shared.auth.domain.TokenRepository;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class TokenProvider implements TokenRepository {
    private final TokenConfiguration tokenConfiguration;

    TokenProvider(final TokenConfiguration tokenConfiguration) {
        this.tokenConfiguration = tokenConfiguration;
    }

    @Override
    public String decodeJWT(String token) {
        byte[] decodedSecret = Base64.getDecoder().decode(this.tokenConfiguration.getSecret());
        Algorithm algorithm = Algorithm.HMAC256(decodedSecret);

        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);

        return jwt.getSubject();
    }

    @Override
    public String encodeJWT(String payload) {
        byte[] decodedSecret = Base64.getDecoder().decode(this.tokenConfiguration.getSecret());
        Algorithm algorithm = Algorithm.HMAC256(decodedSecret);

        return JWT.create()
                .withSubject(payload)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + this.tokenConfiguration.getDuration()))
                .sign(algorithm);
    }
}
