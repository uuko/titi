package com.alin.titi.model.announce;

import java.util.Date;

public class ArticleResponse {
    private Integer articleId;
    private String articleImportant;
    private String articleTag;
    private String articleTitle;
    private String articleContent;
    private Date modifyDate;



    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
