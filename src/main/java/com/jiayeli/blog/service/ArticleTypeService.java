package com.jiayeli.blog.service;

import com.jiayeli.blog.model.article.ArticleType;

import java.util.List;

public interface ArticleTypeService {

    boolean addArticleType(ArticleType blogArticle);
    boolean deleteArticleType(String id);
    boolean updateArticleType(ArticleType blogArticle);
    ArticleType getArticleTypeByid(String id);
    List<ArticleType> getAllArticleType();

    List getTypes();
}
