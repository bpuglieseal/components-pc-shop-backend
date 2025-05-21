package com.componentsshop.apps.backend.controllers.suppliers.finder;

import contexts.shop.suppliers.application.finder.SupplierFinder;
import contexts.shop.suppliers.application.finder.SupplierFinderRequest;
import contexts.shop.suppliers.application.finder.SupplierFinderResponse;
import contexts.shop.suppliers.domain.SupplierNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SupplierFinderController {
    private SupplierFinder finder;

    SupplierFinderController(SupplierFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<HashMap<String, Object>> run (@PathVariable int id) {
        HashMap<String, Object> body = new HashMap<>();
        try {
            SupplierFinderResponse response = this.finder.run(new SupplierFinderRequest(id));
            body.put("supplier", response.getSupplier());
            return new ResponseEntity(body, HttpStatus.OK);
        } catch (SupplierNotExists e) {
            body.put("message", e.getMessage());
            return new ResponseEntity(body, HttpStatus.NOT_FOUND);
        }
    }
}
