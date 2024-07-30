package com.hospital.open_api_document.types;

import java.util.HashMap;
import java.util.Map;

public class CategorySections {
    private String nameCN;
    private Map<String, ApiDoc> topics;

    public CategorySections(String n_cn) {
        this.nameCN = n_cn;
        this.topics = new HashMap<>();
    }

    public String getNameCN() {
        return nameCN;
    }

    public Map<String, ApiDoc> getTopics() {
        return topics;
    }
}
