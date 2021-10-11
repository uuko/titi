package com.alin.titi.model.api.request;

public class BannerRequest {
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public boolean isBanner() {
        return isBanner;
    }

    public void setBanner(boolean banner) {
        isBanner = banner;
    }

    private String picUrl="";
    private boolean isBanner=false;
}
