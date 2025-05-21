package contexts.shop.users.application.login;

public class UserLoginResponse {
    String token;

    UserLoginResponse(final String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
