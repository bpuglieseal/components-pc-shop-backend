package contexts.shop.suppliers.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierJPARepository extends JpaRepository<SupplierJPAEntity, Integer> {
}
