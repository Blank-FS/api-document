package com.hospital.open_api_document.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class ApiTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "name_cn", length = 50, nullable = false)
    private String nameCN;

    @Column(length = 500000, nullable = false)
    private String contentMD;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private ApiCategory category;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCn() {
        return nameCN;
    }

    public void setNameCn(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getContentMd() {
        return contentMD;
    }

    public void setContentMd(String contentMD) {
        this.contentMD = contentMD;
    }

    public ApiCategory getCategory() {
        return category;
    }

    public void setCategory(ApiCategory category) {
        this.category = category;
    }
}
