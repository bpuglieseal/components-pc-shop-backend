package contexts.shop.suppliers.application.finderAll;

import contexts.shop.suppliers.domain.Supplier;
import contexts.shop.suppliers.infrastructure.mappers.SupplierMapper;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPAEntity;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPARepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class SupplierFindAll {
    private final SupplierJPARepository repository;

    SupplierFindAll(SupplierJPARepository repository) {
        this.repository = repository;
    }

    public SupplierFindAllResponse run() {
        ArrayList<SupplierJPAEntity> entities = new ArrayList<>(this.repository.findAll());
        ArrayList<Supplier> suppliers = entities.stream().map(SupplierMapper::fromPersistenceEntityToDomain).collect(Collectors.toCollection(ArrayList::new));
        return new SupplierFindAllResponse(suppliers);
    }
}
