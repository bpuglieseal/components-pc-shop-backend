package contexts.shop.products.domain;

public class ProductRating {
    double rating;

    private void ensureRatingIsValid() {
        if (rating < 0 || rating > 5) {
            throw new ProductRatingInvalid("Rating must be between 0 and 5");
        }
    }

    public ProductRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}
