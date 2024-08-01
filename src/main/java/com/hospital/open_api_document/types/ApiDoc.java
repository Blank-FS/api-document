package com.hospital.open_api_document.types;

import java.util.UUID;

public class ApiDoc {
    private String nameCN;
    private UUID id;
    private String contentMD;

    public ApiDoc(UUID id, String n_cn, String c_md) {
        this.id = id;
        this.nameCN = n_cn;
        this.contentMD = c_md;
    }

    public String getNameCN() {
        return nameCN;
    }

    public String getContentMD() {
        return contentMD;
    }

    public UUID getId() {
        return id;
    }
}
