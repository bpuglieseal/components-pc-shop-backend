package contexts.shop.users.domain;

import jdk.jfr.Label;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleTest {
    @Test
    @Label("UserRole Object Value Should Throw Error")
    public void userRoleTestShouldThrowError() {
        String role = "ANONYMOUS";
        assertThrows(UserRoleNotValid.class, () -> new UserRole(role));
    }

    @Test
    @Label("UserRole Object Value Should NOT Throw Error")
    public void userRoleTestShouldNotThrowError() {
        String role = "ADMIN";
        assertDoesNotThrow(() -> new UserRole(role));
    }
}