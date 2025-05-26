package contexts.shop.products.domain;

public class ProductRatingInvalid extends RuntimeException {
    public ProductRatingInvalid(String message) {
        super(message);
    }
}
