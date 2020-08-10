package com.jiayeli.blog.dao;

import com.jiayeli.blog.model.BlogArticle;

import java.util.List;

public interface BlogArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogArticle record);

    int insertSelective(BlogArticle record);

    BlogArticle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogArticle record);

    int updateByPrimaryKey(BlogArticle record);

    List<BlogArticle> selectArticlesByType(String type);

    List<BlogArticle> selectAllBlogArticles();
}