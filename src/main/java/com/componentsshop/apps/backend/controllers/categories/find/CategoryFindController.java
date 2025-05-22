package com.componentsshop.apps.backend.controllers.categories.find;

import contexts.shop.categories.application.finder.CategoryFinder;
import contexts.shop.categories.application.finder.CategoryFinderRequest;
import contexts.shop.categories.application.finder.CategoryFinderResponse;
import contexts.shop.categories.domain.Category;
import contexts.shop.categories.domain.CategoryNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CategoryFindController {
    private final CategoryFinder finder;

    CategoryFindController(final CategoryFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<HashMap<String, Object>> run (@PathVariable final int id) {
        HashMap<String, Object> body = new HashMap<>();
        try {
            CategoryFinderResponse response = this.finder.run(new CategoryFinderRequest(id));
            body.put("category", response.getCategory());
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (CategoryNotExists e) {
            body.put("message", e.getMessage());
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }
}
