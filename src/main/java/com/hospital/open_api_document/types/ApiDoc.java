package com.hospital.open_api_document.types;

public class ApiDoc {
    private String nameCN;
    private String contentMD;

    public ApiDoc(String n_cn, String c_md) {
        this.nameCN = n_cn;
        this.contentMD = c_md;
    }

    public String getNameCN() {
        return nameCN;
    }

    public String getContentMD() {
        return contentMD;
    }
}
