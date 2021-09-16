package com.alin.titi.model.announce;

public class ArticleRequest {


    //    文字(包含圖網址),標題,被選中當banner的圖網址,重要程度預設普通 -> U / E / O,標籤
    private Integer articleId;
    private String articleImportant="O";
    private String articleTag;
    private String articleTitle;
    private String articleContent;
    private String bannerUrl="";

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }



    public String getArticleImportant() {
        return articleImportant;
    }

    public void setArticleImportant(String articleImportant) {
        this.articleImportant = articleImportant;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = articleTag;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }


}

