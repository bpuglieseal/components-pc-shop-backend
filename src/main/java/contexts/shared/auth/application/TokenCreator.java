package contexts.shared.auth.application;

import contexts.shared.auth.infrastructure.TokenProvider;
import org.springframework.stereotype.Service;

@Service
public class TokenCreator {
    private TokenProvider provider;

    TokenCreator(TokenProvider provider) {
        this.provider = provider;
    }

    public String run (String payload) {
        return this.provider.encodeJWT(payload);
    }
}
