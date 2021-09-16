package com.alin.titi.repository;

import com.alin.titi.model.announce.ArticleModel;
import com.alin.titi.model.articalpic.ArticlePicModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticlePicRepository extends JpaRepository<ArticlePicModel, Integer> {
    ArticlePicModel findByPicUrl(String picUrl);
    List<ArticlePicModel> findByBanner(Boolean banner);
    ArticlePicModel findByPicId(Integer picId);
    void deleteByArticleModel(ArticleModel articleModel);

}
