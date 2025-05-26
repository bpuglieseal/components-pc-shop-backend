package contexts.shop.products.domain;

public class ProductStockInvalid extends RuntimeException {
  public ProductStockInvalid(String message) {
    super(message);
  }
}
