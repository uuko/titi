package com.alin.titi.repository;


import com.alin.titi.model.announce.ArticleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleModel, Integer> {
    ArticleModel findByArticleId(Integer articleId);
    Page<ArticleModel> findByArticleImportant(String important, Pageable pageable);
    Page<ArticleModel> findByArticleTag(String tag, Pageable pageable);
}
