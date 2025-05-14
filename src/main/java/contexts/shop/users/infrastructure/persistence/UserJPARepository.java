package contexts.shop.users.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserJPAEntity, Integer> {
}
