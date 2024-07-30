package com.hospital.open_api_document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.open_api_document.model.ApiTopic;
import com.hospital.open_api_document.service.ApiTopicService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/links")
public class ApiLinksController {

    @Autowired
    private ApiTopicService apiTopicService;

    @GetMapping
    public ResponseEntity<List<String>> getLinks() {
        List<ApiTopic> topics = apiTopicService.getAllTopics();

        List<String> links = new ArrayList<>();

        for (ApiTopic topic : topics) {
            String link = String.format("http://localhost:8080/api/documents/%s/%s",
                    topic.getCategory().getName(), topic.getName());
            links.add(link);
        }

        return ResponseEntity.ok(links);
    }
}
