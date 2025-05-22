package contexts.shop.categories.application.finder;

import contexts.shop.categories.domain.Category;

public class CategoryFinderResponse {
    private Category category;

    CategoryFinderResponse(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
