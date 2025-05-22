package contexts.shop.suppliers.application;

import contexts.shop.suppliers.application.finderAll.SupplierFindAll;
import contexts.shop.suppliers.application.finderAll.SupplierFindAllResponse;
import contexts.shop.suppliers.domain.Supplier;
import contexts.shop.suppliers.domain.SupplierMother;
import contexts.shop.suppliers.infrastructure.mappers.SupplierMapper;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPAEntity;
import contexts.shop.suppliers.infrastructure.persistence.SupplierJPARepository;
import jdk.jfr.Label;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class SupplierFindAllTest {
    @Mock
    private SupplierJPARepository repository;

    @InjectMocks
    private SupplierFindAll findAll;

    @Test
    @Label("supplier finder should return an array instance of suppliers")
    public void supplierFinderShouldReturnAnArrayInstanceOfSuppliers() {
        Supplier supplier = SupplierMother.withRandomSupplier();
        SupplierJPAEntity supplierEntity = SupplierMapper.toPersitenceEntity(supplier.getId(), supplier.getName(), supplier.getCountry());

        ArrayList<SupplierJPAEntity> suppliers = new ArrayList<>();
        suppliers.add(supplierEntity);

        when(repository.findAll()).thenReturn(suppliers);
        SupplierFindAllResponse response = this.findAll.run();

        assertInstanceOf(Supplier.class, response.getSuppliers().get(0));
    }
}