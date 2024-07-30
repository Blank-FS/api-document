package com.hospital.open_api_document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.open_api_document.model.ApiCategory;
import com.hospital.open_api_document.repository.ApiCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiCategoryService {

    @Autowired
    private ApiCategoryRepository apiCategoryRepository;

    public List<ApiCategory> getAllCategories() {
        return apiCategoryRepository.findAll();
    }

    public Optional<ApiCategory> getCategoryById(UUID id) {
        return apiCategoryRepository.findById(id);
    }

    public ApiCategory saveCategory(ApiCategory category) {
        return apiCategoryRepository.save(category);
    }

    public void deleteCategory(UUID id) {
        apiCategoryRepository.deleteById(id);
    }

    public Optional<ApiCategory> getCategoryByName(String name) {
        return apiCategoryRepository.findByName(name);
    }
}
