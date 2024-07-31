package com.hospital.open_api_document.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.open_api_document.model.ApiCategory;
import com.hospital.open_api_document.model.ApiTopic;

public interface ApiTopicRepository extends JpaRepository<ApiTopic, UUID> {
    // Custom query methods (if needed)
    Optional<ApiTopic> findByNameAndCategory(String name, ApiCategory category);

    List<ApiTopic> findAllByOrderByNameCNAsc();
}
