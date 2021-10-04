package com.alin.titi.model;

public class ArticleTagResponse {
    private String tag="";

    public ArticleTagResponse(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
