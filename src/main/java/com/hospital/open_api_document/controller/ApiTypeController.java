package com.hospital.open_api_document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.open_api_document.model.ApiType;
import com.hospital.open_api_document.service.ApiTypeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/types")
public class ApiTypeController {

    @Autowired
    private ApiTypeService apiTypeService;

    @GetMapping
    public List<ApiType> getAllType() {
        return apiTypeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiType> getTypeById(@PathVariable UUID id) {
        Optional<ApiType> type = apiTypeService.getTypeById(id);
        return type.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiType> createType(@RequestBody ApiType type) {
        ApiType createdCategory = apiTypeService.saveType(type);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiType> updateType(@PathVariable UUID id, @RequestBody ApiType type) {
        if (!apiTypeService.getTypeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        type.setId(id);
        ApiType updateType = apiTypeService.saveType(type);
        return ResponseEntity.ok(updateType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable UUID id) {
        if (!apiTypeService.getTypeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        apiTypeService.deleteType(id);
        return ResponseEntity.noContent().build();
    }
}
