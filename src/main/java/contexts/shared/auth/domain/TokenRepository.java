package contexts.shared.auth.domain;

public interface TokenRepository {
    String decodeJWT(String token);
    String encodeJWT(String payload);
}
