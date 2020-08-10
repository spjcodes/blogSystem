package com.jiayeli.blog.service;

import com.jiayeli.blog.model.BlogArticle;

import java.util.List;

public interface BlogArticleSer {

    boolean addBlogArticle(BlogArticle blogArticle);
    boolean deleteBlogArticle(String id);
    boolean updateBlogArticle(BlogArticle blogArticle);
    BlogArticle getBlogArticleById(String id);
    List<BlogArticle> getBlogArticlesByType(String type);
    List<BlogArticle> getAllBlogArticles();

}
