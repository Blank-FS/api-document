package com.hospital.open_api_document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.open_api_document.model.ApiType;
import com.hospital.open_api_document.repository.ApiTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiTypeService {

    @Autowired
    private ApiTypeRepository apiTypeRepository;

    public List<ApiType> getAllTypes() {
        return apiTypeRepository.findAll();
    }

    public Optional<ApiType> getTypeById(UUID id) {
        return apiTypeRepository.findById(id);
    }

    public ApiType saveType(ApiType category) {
        return apiTypeRepository.save(category);
    }

    public void deleteType(UUID id) {
        apiTypeRepository.deleteById(id);
    }

    public Optional<ApiType> getTypeByName(String name) {
        return apiTypeRepository.findByName(name);
    }
}
