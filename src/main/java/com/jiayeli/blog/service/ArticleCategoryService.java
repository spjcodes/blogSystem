package com.jiayeli.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiayeli.blog.dto.ArticleCategoryDto;
import com.jiayeli.blog.model.article.ArticleCategoryModel;

import java.util.List;

public interface ArticleCategoryService extends IService<ArticleCategoryModel> {

    public List<ArticleCategoryDto> getArticleCategoryListByAuthorId(String authorId);

}
