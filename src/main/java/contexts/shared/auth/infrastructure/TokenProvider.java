package contexts.shared.auth.infrastructure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import contexts.shared.auth.domain.TokenRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.Objects;

@Component
public class TokenProvider implements TokenRepository {
    private String secret;
    private long duration;

    private Environment environment;

    TokenProvider (Environment environment) {
        this.secret = environment.getProperty("jwt.secret");
        this.duration = Long.parseLong(Objects.requireNonNull(environment.getProperty("jwt.duration")));
    }

    @Override
    public String decodeJWT(String token) {
        System.out.println(token);
        byte[] decodedSecret = Base64.getDecoder().decode(this.secret);
        Algorithm algorithm = Algorithm.HMAC256(decodedSecret);

        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);

        return jwt.getSubject();
    }

    @Override
    public String encodeJWT(String payload) {
        System.out.println(this.environment.getProperty("jwt.secret"));
        byte[] decodedSecret = Base64.getDecoder().decode(this.secret);
        Algorithm algorithm = Algorithm.HMAC256(decodedSecret);

        return JWT.create()
                .withSubject(payload)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + this.duration))
                .sign(algorithm);
    }
}
