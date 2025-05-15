package contexts.shared.auth.application;

import contexts.shared.auth.infrastructure.TokenProvider;

public class TokenValidator {
    private TokenProvider provider;

    TokenValidator(TokenProvider provider) {
        this.provider = provider;
    }

    public String validate(String token) {
        return this.provider.decodeJWT(token);
    }
}
