package contexts.shop.suppliers.infrastructure.mappers;

import contexts.shop.suppliers.domain.Supplier;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPAEntity;

public class SupplierMapper {
    public static Supplier fromPersistenceEntityToDomain (SupplierJPAEntity supplierJPAEntity) {
        return new Supplier(supplierJPAEntity.getId(), supplierJPAEntity.getName(), supplierJPAEntity.getCountry());
    }

    public static SupplierJPAEntity toPersitenceEntity (int id, String name, String country) {
        return new SupplierJPAEntity(id, name, country);
    }
}
