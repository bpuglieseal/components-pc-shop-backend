package contexts.shop.categories.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJPARepository extends JpaRepository<CategoryJPAEntity, Integer> {
}
