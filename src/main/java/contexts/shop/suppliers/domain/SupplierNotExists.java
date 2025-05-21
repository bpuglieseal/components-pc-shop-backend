package contexts.shop.suppliers.domain;

public class SupplierNotExists extends RuntimeException {
  public SupplierNotExists(String message) {
    super(message);
  }
}
