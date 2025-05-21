package contexts.shop.users.domain;

import com.github.javafaker.Faker;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserEmailTest {
    @Test
    @Label("Should throw user email invalid exception")
    void shouldThrowUserEmailInvalidException() {
        String email = "testwrongEmail";
        assertThrows(UserEmailNotValid.class, () -> new UserEmail(email));
    }

    @Test
    @Label("Should not throw user email exception")
    void shouldNotThrowUserEmailException() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        assertDoesNotThrow(() -> new UserEmail(email));
    }
}