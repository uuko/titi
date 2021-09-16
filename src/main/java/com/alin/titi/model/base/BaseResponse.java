package com.alin.titi.model.base;

public class BaseResponse {
    public BaseResponse() {

    }
    public BaseResponse(String responseContent) {
        this.responseContent = responseContent;
    }

    private String  responseContent="";

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }
}
