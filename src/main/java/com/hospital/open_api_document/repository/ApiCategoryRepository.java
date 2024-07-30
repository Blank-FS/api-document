package com.hospital.open_api_document.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.open_api_document.model.ApiCategory;
import com.hospital.open_api_document.model.ApiType;

public interface ApiCategoryRepository extends JpaRepository<ApiCategory, UUID> {
    // Custom query methods (if needed)
    Optional<ApiCategory> findByName(String name);

    List<ApiCategory> findByType(ApiType topic);
}
