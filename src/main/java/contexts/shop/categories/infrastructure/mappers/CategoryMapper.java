package contexts.shop.categories.infrastructure.mappers;

import contexts.shop.categories.domain.Category;
import contexts.shop.categories.infrastructure.persistence.CategoryJPAEntity;

public class CategoryMapper {
    public static Category fromPersistenceEntityToDomain (CategoryJPAEntity categoryJPAEntity) {
        return new Category(categoryJPAEntity.getId(), categoryJPAEntity.getName(), categoryJPAEntity.getDescription());
    }

    public static CategoryJPAEntity toPersistanceEntity (int id, String name, String description) {
        return new CategoryJPAEntity(id, name, description);
    }
}
