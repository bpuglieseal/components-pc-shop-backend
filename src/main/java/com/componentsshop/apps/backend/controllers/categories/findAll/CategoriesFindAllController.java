package com.componentsshop.apps.backend.controllers.categories.findAll;

import contexts.shop.categories.application.findAll.CategoryFindAll;
import contexts.shop.categories.application.findAll.CategoryFindAllResponse;
import contexts.shop.categories.domain.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CategoriesFindAllController {
    private final CategoryFindAll findAll;

    CategoriesFindAllController(final CategoryFindAll findAll) {
        this.findAll = findAll;
    }

    @GetMapping("/categories")
    public ResponseEntity<HashMap<String, Object>> findAll() {
        CategoryFindAllResponse response = this.findAll.run();
        ArrayList<Category> categories = response.getCategories();

        HashMap<String, Object> body = new HashMap<>();
        body.put("categories", categories);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
