package contexts.shop.products.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductJPAEntity, Integer> {
}
