package contexts.shop.users.domain;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class UserBirthdate {
    private final LocalDate birthdate;

    public UserBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        this.ensureUserAgeAbove18();
    }

    public void ensureUserAgeAbove18() throws UserAgeNotValid {
        LocalDate now = LocalDate.now();

        if(Period.between(this.birthdate, now).getYears() < 18){
            throw new UserAgeNotValid("User birthdate is too young.");
        }
    }
}
