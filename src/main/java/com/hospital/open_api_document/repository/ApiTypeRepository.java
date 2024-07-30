package com.hospital.open_api_document.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.open_api_document.model.ApiType;

public interface ApiTypeRepository extends JpaRepository<ApiType, UUID> {
    // Custom query methods (if needed)
    Optional<ApiType> findByName(String name);
}
