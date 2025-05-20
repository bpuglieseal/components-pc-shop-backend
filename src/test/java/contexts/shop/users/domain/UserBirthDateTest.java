package contexts.shop.users.domain;

import jdk.jfr.Label;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class UserBirthDateTest {

    @Test
    @Label("UserBirthDate Object Value Should Throw Error")
    public void userBirthDateTestShouldThrowError() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateMinor = LocalDate.parse("14/05/2010", formatter);

        Exception exception = assertThrows(UserAgeNotValid.class, () -> new UserBirthdate(dateMinor));
        assertEquals("User birthdate is too young.", exception.getMessage());
    }

    @Test
    @Label("UserBirthDate Object Value Should NOT Throw Error")
    public void userBirthDateTestShouldNotThrowError() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOverage = LocalDate.parse("14/05/2005", formatter);

        assertDoesNotThrow(() -> new UserBirthdate(dateOverage));
    }

}
