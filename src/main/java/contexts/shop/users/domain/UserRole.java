package contexts.shop.users.domain;

enum Role {
    ADMIN, USER
}

public class UserRole {
    Role role;

    UserRole(String role) {
        this.ensureIsValidRole(role);
        this.role = Role.valueOf(role);
    }

    private void ensureIsValidRole (String role) {
        if (!role.equals(Role.ADMIN.toString()) && !role.equals(Role.USER.toString())) {
            throw new UserRoleNotValid(String.format("%s is not a valid user role", role));
        }
    }
}
