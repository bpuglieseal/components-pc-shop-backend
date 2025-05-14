package contexts.shop.users.domain;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String direction;
    private UserBirthdate birthdate;
    public User(int id, String name, String email, String password, String direction, Date birthdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.direction = direction;
        this.birthdate = new UserBirthdate(birthdate);
    }

}
