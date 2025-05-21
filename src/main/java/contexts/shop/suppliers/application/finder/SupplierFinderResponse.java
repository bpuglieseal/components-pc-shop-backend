package contexts.shop.suppliers.application.finder;

import contexts.shop.suppliers.domain.Supplier;

public class SupplierFinderResponse {
    private final Supplier supplier;

    public SupplierFinderResponse(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }
}
