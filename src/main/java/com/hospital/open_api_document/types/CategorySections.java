package com.hospital.open_api_document.types;

import java.util.LinkedHashMap;

public class CategorySections {
    private String nameCN;
    private LinkedHashMap<String, ApiDoc> topics;

    public CategorySections(String n_cn) {
        this.nameCN = n_cn;
        this.topics = new LinkedHashMap<>();
    }

    public String getNameCN() {
        return nameCN;
    }

    public LinkedHashMap<String, ApiDoc> getTopics() {
        return topics;
    }
}
