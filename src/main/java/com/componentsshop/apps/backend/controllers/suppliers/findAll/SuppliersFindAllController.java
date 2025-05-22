package com.componentsshop.apps.backend.controllers.suppliers.findAll;

import contexts.shop.suppliers.application.finderAll.SupplierFindAll;
import contexts.shop.suppliers.application.finderAll.SupplierFindAllResponse;
import contexts.shop.suppliers.domain.Supplier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class SuppliersFindAllController {
    private final SupplierFindAll findAll;

    SuppliersFindAllController(SupplierFindAll findAll) {
        this.findAll = findAll;
    }

    @GetMapping("/suppliers")
    public ResponseEntity<HashMap<String, Object>> findAllSuppliers() {
        SupplierFindAllResponse response = this.findAll.run();
        ArrayList<Supplier> suppliers = response.getSuppliers();

        HashMap<String, Object> body = new HashMap<>();
        body.put("suppliers", suppliers);

        return ResponseEntity.ok(body);
    }
}
