package com.hospital.open_api_document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.open_api_document.model.ApiCategory;
import com.hospital.open_api_document.service.ApiCategoryService;
import com.hospital.open_api_document.utils.StringHelper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class ApiCategoryController {

    @Autowired
    private ApiCategoryService apiCategoryService;

    @GetMapping
    public List<ApiCategory> getAllCategories() {
        return apiCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiCategory> getCategoryById(@PathVariable UUID id) {
        Optional<ApiCategory> category = apiCategoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiCategory> createCategory(@RequestBody ApiCategory category) {
        ApiCategory createdCategory = apiCategoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiCategory> updateCategory(@PathVariable UUID id, @RequestBody ApiCategory category) {
        if (!apiCategoryService.getCategoryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        category.setId(id);
        ApiCategory updatedCategory = apiCategoryService.saveCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        if (!apiCategoryService.getCategoryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        apiCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/name-cn/{id}")
    public ResponseEntity<ApiCategory> updateCategoryNameCN(@PathVariable UUID id, @RequestBody String nameCN) {
        Optional<ApiCategory> category = apiCategoryService.getCategoryById(id);
        if (!category.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ApiCategory updateCategory = category.get();
        nameCN = StringHelper.removeExtraDoubleQuotes(nameCN);
        updateCategory.setNameCN(nameCN);
        updateCategory = apiCategoryService.saveCategory(updateCategory);
        return ResponseEntity.ok(updateCategory);
    }
}
