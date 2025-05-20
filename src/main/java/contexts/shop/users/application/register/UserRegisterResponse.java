package contexts.shop.users.application.register;

public class UserRegisterResponse {
    private String token;

    public UserRegisterResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
