package contexts.shop.suppliers.application.finder;

public class SupplierFinderRequest {
    private final int id;

    public SupplierFinderRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
