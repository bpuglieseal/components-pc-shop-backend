package context.shop.users.domain;

import contexts.shop.users.domain.UserAgeNotValid;
import contexts.shop.users.domain.UserBirthdate;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserBirthDateTest {

    @Test
    @Label("UserBirthDate Object Value Should Throw Error")
    public void userBirthDateTest() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date dateMinor = formatter.parse("14/05/2010");
        Exception exception = assertThrows(UserAgeNotValid.class, () -> new UserBirthdate(dateMinor));
        assertEquals("User birthdate is too young.", exception.getMessage());
    }

    @Test
    @Label("UserBirthDate Object Value Should NOT Throw Error")
    public void userBirthDateTestShouldNotThrowError() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date dateOverage = formatter.parse("14/05/2005");
        assertDoesNotThrow(() -> {
            new UserBirthdate(dateOverage);
        });
    }

}
