package contexts.shop.suppliers.application.finder;

import contexts.shop.suppliers.domain.Supplier;
import contexts.shop.suppliers.domain.SupplierNotExists;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPAEntity;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPARepository;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SupplierFinderTest {
    @Mock
    private SupplierJPARepository repository;

    @InjectMocks
    private SupplierFinder finder;

    @Test
    @Label("Supplier finder should execute repository service and return an supplier domain entity")
    public void shouldExecuteRepositoryServiceAndReturnSupplierDomainEntity() {
        final int id = 1;
        SupplierJPAEntity entity = new SupplierJPAEntity(id, "test", "test");

        when(repository.findById(id)).thenReturn(Optional.of(entity));

        SupplierFinderResponse response = this.finder.run(new SupplierFinderRequest(id));
        assertNotNull(response.getSupplier());
        assertInstanceOf(Supplier.class, response.getSupplier());
    }

    @Test
    @Label("Supplier finder should throw a supplier not exists exception")
    public void shouldThrowSupplierNotFoundException() {
        final int id = 4;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(SupplierNotExists.class, () -> this.finder.run(new SupplierFinderRequest(id)));
    }
}