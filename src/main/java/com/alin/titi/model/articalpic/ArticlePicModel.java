package com.alin.titi.model.articalpic;

import com.alin.titi.model.announce.ArticleModel;

import javax.persistence.*;

@Entity(name = "main_article_pic")
public class ArticlePicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer picId;
    private String picUrl;
    private boolean banner=false;


    @ManyToOne
    @JoinColumn(name="articleId", nullable=false)
    private ArticleModel articleModel;

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

    public boolean isBanner() {
        return banner;
    }

    public void setBanner(boolean banner) {
        this.banner = banner;
    }

    public ArticleModel getArticleModel() {
        return articleModel;
    }

    public void setArticleModel(ArticleModel articleModel) {
        this.articleModel = articleModel;
    }
}
