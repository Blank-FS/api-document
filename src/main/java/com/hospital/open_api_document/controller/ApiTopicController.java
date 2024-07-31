package com.hospital.open_api_document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.open_api_document.model.ApiCategory;
import com.hospital.open_api_document.model.ApiTopic;
import com.hospital.open_api_document.model.ApiType;
import com.hospital.open_api_document.service.ApiCategoryService;
import com.hospital.open_api_document.service.ApiTopicService;
import com.hospital.open_api_document.service.ApiTypeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/topics")
public class ApiTopicController {

    @Autowired
    private ApiTopicService apiTopicService;

    @Autowired
    private ApiCategoryService apiCategoryService;

    @Autowired
    private ApiTypeService apiTypeService;

    @GetMapping
    public ResponseEntity<List<ApiTopic>> getAllTopics() {
        List<ApiTopic> topics = apiTopicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<ApiTopic>> getAllTopicsByType(@PathVariable String type) {
        Optional<ApiType> apiType = apiTypeService.getTypeByName(type);
        if (!apiType.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        ApiType unwrappedType = apiType.get();

        List<ApiTopic> topics = apiTopicService.getAllTopics();
        int size = topics.size();
        for (int i = size - 1; i >= 0; i--)
            if (topics.get(i).getCategory().getType() != unwrappedType)
                topics.remove(i);
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ApiTopic> getTopicById(@PathVariable UUID id) {
        Optional<ApiTopic> topic = apiTopicService.getTopicById(id);
        return topic.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiTopic> createTopic(@RequestBody ApiTopic topic) {
        UUID categoryId = topic.getCategory().getId();
        Optional<ApiCategory> categoryOptional = apiCategoryService.getCategoryById(categoryId);

        if (!categoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        topic.setCategory(categoryOptional.get());
        ApiTopic createdTopic = apiTopicService.saveTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopic);
    }

    @PutMapping("/md/{id}")
    public ResponseEntity<ApiTopic> updateMd(@PathVariable UUID id, @RequestBody String topic) {
        Optional<ApiTopic> topicOptional = apiTopicService.getTopicById(id);
        if (!topicOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        // Remove extra double quotation marks
        int length = topic.length();
        if (topic.charAt(length - 1) == '\"')
            topic = topic.substring(0, length - 1);
        if (topic.charAt(0) == '\"')
            topic = topic.substring(1, length - 1);
        // Update Markdown content of the specific topic
        ApiTopic updatedTopic = topicOptional.get();
        updatedTopic.setContentMd(topic);
        apiTopicService.saveTopic(updatedTopic);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteTopicById(@PathVariable UUID id) {
        if (!apiTopicService.getTopicById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        apiTopicService.deleteTopic(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
