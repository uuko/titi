package com.alin.titi.model.announce;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "main_article")
public class ArticleModel {
    public ArticleModel() {

    }
    public ArticleModel(Integer articleId) {
        this.articleId = articleId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer articleId;
    private String articleImportant;
    private String articleTag;
    private String articleTitle;
    private String articleContent;
    private Date modifyDate;
    @OneToMany()
    private Set<ArticleModel> articleModelSet = new HashSet<>();
    public Set<ArticleModel> getArticleModelSet() {
        return articleModelSet;
    }
    public void setArticleModelSet(Set<ArticleModel> articleModelSet) {
        this.articleModelSet = articleModelSet;
    }

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
