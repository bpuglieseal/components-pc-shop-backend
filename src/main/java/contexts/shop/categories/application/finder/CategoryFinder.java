package contexts.shop.categories.application.finder;

import contexts.shop.categories.domain.CategoryNotExists;
import contexts.shop.categories.infrastructure.mappers.CategoryMapper;
import contexts.shop.categories.infrastructure.persistence.CategoryJPAEntity;
import contexts.shop.categories.infrastructure.persistence.CategoryJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryFinder {
    private final CategoryJPARepository repository;

    CategoryFinder(CategoryJPARepository repository) {
        this.repository = repository;
    }

    public CategoryFinderResponse run (CategoryFinderRequest request) {
        Optional<CategoryJPAEntity> entity = repository.findById(request.getId());
        return entity
                .map(e -> new CategoryFinderResponse(CategoryMapper.fromPersistenceEntityToDomain(e)))
                .orElseThrow(() -> new CategoryNotExists("Could not find category with id " + request.getId()));

    }
}
