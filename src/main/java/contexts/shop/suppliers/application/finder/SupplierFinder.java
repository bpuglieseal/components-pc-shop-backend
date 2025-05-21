package contexts.shop.suppliers.application.finder;

import contexts.shop.suppliers.domain.SupplierNotExists;
import contexts.shop.suppliers.infrastructure.mappers.SupplierMapper;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPAEntity;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierFinder {
    private final SupplierJPARepository repository;

    SupplierFinder(SupplierJPARepository repository) {
        this.repository = repository;
    }

    public SupplierFinderResponse run (SupplierFinderRequest request) {
        Optional<SupplierJPAEntity> entity = repository.findById(request.getId());
        return entity
                .map(e -> new SupplierFinderResponse(SupplierMapper.fromPersitenceEntityToDomain(e)))
                .orElseThrow(() -> new SupplierNotExists(String.format("Supplier with id %s not found", request.getId())));
    }
}
