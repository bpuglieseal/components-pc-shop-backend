package contexts.shop.categories.application.findAll;

import contexts.shop.categories.domain.Category;
import contexts.shop.categories.infrastructure.mappers.CategoryMapper;
import contexts.shop.categories.infrastructure.persistence.CategoryJPAEntity;
import contexts.shop.categories.infrastructure.persistence.CategoryJPARepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CategoryFindAll {
    private final CategoryJPARepository repository;

    CategoryFindAll(final CategoryJPARepository repository) {
        this.repository = repository;
    }

    public CategoryFindAllResponse run () {
        ArrayList<CategoryJPAEntity> entities = new ArrayList<>(this.repository.findAll());
        ArrayList<Category> categories = entities.stream().map(CategoryMapper::fromPersistenceEntityToDomain).collect(Collectors.toCollection(ArrayList::new));
        return new CategoryFindAllResponse(categories);
    }
}
