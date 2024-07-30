package com.hospital.open_api_document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.open_api_document.model.ApiCategory;
import com.hospital.open_api_document.model.ApiTopic;
import com.hospital.open_api_document.repository.ApiTopicRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiTopicService {

    @Autowired
    private ApiTopicRepository apiTopicRepository;

    public List<ApiTopic> getAllTopics() {
        return apiTopicRepository.findAll();
    }

    public Optional<ApiTopic> getTopicById(UUID id) {
        return apiTopicRepository.findById(id);
    }

    public ApiTopic saveTopic(ApiTopic topic) {
        return apiTopicRepository.save(topic);
    }

    public void deleteTopic(UUID id) {
        apiTopicRepository.deleteById(id);
    }

    public Optional<ApiTopic> getTopicByNameAndCategory(String name, ApiCategory category) {
        return apiTopicRepository.findByNameAndCategory(name, category);
    }
}
