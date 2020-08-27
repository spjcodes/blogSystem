package com.jiayeli.blog.service;

import com.jiayeli.blog.model.BlogArticle;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface BlogArticleSer {

    boolean addBlogArticle(BlogArticle blogArticle);
    boolean deleteBlogArticle(String id);
    boolean updateBlogArticle(BlogArticle blogArticle);
    BlogArticle getBlogArticleById(String id);
    List<BlogArticle> getBlogArticlesByType(String type);
    List<BlogArticle> getAllBlogArticles();
    Map fileUpload(String filePath, MultipartFile uploadFile);

    String ckeditUpload(MultipartFile file, String ckEditorFuncNum);
}
