package contexts.shop.products.domain;

public class ProductStock {
    private final int stock;

    private void ensureStockIsMajorThanZero() {
        if (this.stock < 0) {
            throw new ProductStockInvalid("Product stock must be a positive number and equal or more than zero");
        }
    }

    ProductStock(int stock) {
        this.stock = stock;
    }

    int getStock() {
        return this.stock;
    }
}
