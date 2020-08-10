package com.jiayeli.blog.service;

import com.jiayeli.blog.model.ArticleType;

import java.util.List;

public interface ArticleTypeSer {

    boolean addArticleType(ArticleType blogArticle);
    boolean deleteArticleType(String id);
    boolean updateArticleType(ArticleType blogArticle);
    ArticleType getArticleTypeByid(String id);
    List<ArticleType> getAllArticleType();
}
