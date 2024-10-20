package com.jiayeli.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiayeli.blog.model.ArticleModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArticleService extends IService<ArticleModel>  {

    boolean addBlogArticle(ArticleModel blogArticle);
    boolean deleteBlogArticle(String id);
    boolean updateBlogArticle(ArticleModel blogArticle);
    ArticleModel getArticleById(String id);
    List<ArticleModel> getArticleList(String type);
    List<ArticleModel> getArticleList();
    Map<String, String> fileUpload(String filePath, MultipartFile uploadFile);

    String ckeditUpload(MultipartFile file, String ckEditorFuncNum);

    void visitsCount(String blogArticle);
}

