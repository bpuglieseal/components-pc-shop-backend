package contexts.shop.suppliers.application.finderAll;

import contexts.shop.suppliers.domain.Supplier;

import java.util.ArrayList;

public class SupplierFindAllResponse {
    private ArrayList<Supplier> suppliers;

    SupplierFindAllResponse(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
}
