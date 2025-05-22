package contexts.shop.categories.infrastructure.persistence;

import contexts.shop.categories.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJPARepository extends JpaRepository<CategoryJPAEntity, Integer> {
}
