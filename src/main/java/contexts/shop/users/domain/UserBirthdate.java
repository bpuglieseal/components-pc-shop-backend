package contexts.shop.users.domain;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class UserBirthdate {
    private Date birthdate;
    public UserBirthdate(Date birthdate) {
        this.birthdate = birthdate;
        this.ensureUserAgeAbove18();
    }
    public void ensureUserAgeAbove18(){
        LocalDate birthDate = this.birthdate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate now = LocalDate.now();
        if(Period.between(birthDate, now).getYears()<18){
            throw new UserAgeNotValid("User birthdate is too young.");
        }
    }
}
