package com.hospital.open_api_document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.open_api_document.model.ApiCategory;
import com.hospital.open_api_document.model.ApiTopic;
import com.hospital.open_api_document.service.ApiCategoryService;
import com.hospital.open_api_document.service.ApiDocumentService;
import com.hospital.open_api_document.service.ApiTopicService;
import com.hospital.open_api_document.types.CategorySections;
import com.hospital.open_api_document.utils.StringHelper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "${FRONT_END}")
@RequestMapping("/api/documents")
public class ApiDocumentController {

    @Autowired
    private ApiCategoryService apiCategoryService;

    @Autowired
    private ApiTopicService apiTopicService;

    @Autowired
    private ApiDocumentService apiDocumentService;

    @GetMapping("/{category}/{topic}")
    public ResponseEntity<String> getDocument(@PathVariable("category") String category,
            @PathVariable("topic") String topic) {
        // Find the ApiCategory by name
        Optional<ApiCategory> categoryOptional = apiCategoryService.getCategoryByName(category);
        if (!categoryOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        // Find the ApiTopic by name and category
        ApiCategory apiCategory = categoryOptional.get();
        Optional<ApiTopic> topicOptional = apiTopicService.getTopicByNameAndCategory(topic, apiCategory);
        if (!topicOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        // Return the contentMd
        ApiTopic apiTopic = topicOptional.get();
        return ResponseEntity.ok(StringHelper.doNotShowEscapeDoubleQuote(apiTopic.getContentMd()));
    }

    // 根据 API 领域返回对应的 API 文档信息，包括其所属的 API 种类和 API 话题
    @GetMapping("/{type}")
    public ResponseEntity<LinkedHashMap<String, CategorySections>> getSortedSectionsByType(
            @PathVariable("type") String type) {
        LinkedHashMap<String, CategorySections> value = apiDocumentService.getSortedSectionsByType(type);
        // 如果信息没从数据库中找到， 返回 404
        if (value == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        // 返回相应的数据
        return ResponseEntity.ok(value);
    }

    // 返回所有 API 文档信息，包括他们的 API 种类和 API 话题信息， 不包括其所属的 API 领域信息
    @GetMapping
    public ResponseEntity<Map<String, CategorySections>> getAllSections() {
        return ResponseEntity.ok(apiDocumentService.getAllSections());
    }

}
