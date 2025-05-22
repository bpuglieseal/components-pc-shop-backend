package contexts.shop.categories.application.findAll;

import contexts.shop.categories.domain.Category;

import java.util.ArrayList;

public class CategoryFindAllResponse {
    private final ArrayList<Category> categories;

    CategoryFindAllResponse(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }
}
