package contexts.shop.users.infrastructure.persistence;

import contexts.shop.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Integer> {
}
