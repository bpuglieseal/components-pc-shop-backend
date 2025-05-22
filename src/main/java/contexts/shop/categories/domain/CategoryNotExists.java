package contexts.shop.categories.domain;

public class CategoryNotExists extends RuntimeException {
    public CategoryNotExists(String message) {
        super(message);
    }
}
