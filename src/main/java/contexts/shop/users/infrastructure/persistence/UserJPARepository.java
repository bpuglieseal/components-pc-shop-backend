package contexts.shop.users.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserJPAEntity, Integer> {
    Optional<UserJPAEntity> findByEmail(String email);
}
