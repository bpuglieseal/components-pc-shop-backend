package contexts.shop.categories.application.finder;

public class CategoryFinderRequest {
    private int id;

    public CategoryFinderRequest(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
