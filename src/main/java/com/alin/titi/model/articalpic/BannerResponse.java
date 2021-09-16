package com.alin.titi.model.articalpic;

public class BannerResponse {
//    回傳:總數量,圖片id,圖片url,文章id

    private Integer picId;
    private String picUrl;
    private Integer articleId;



    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
