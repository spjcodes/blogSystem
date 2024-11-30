package com.jiayeli.blog.service.impl;

import com.jiayeli.blog.dao.ArticleTypeMapper;
import com.jiayeli.blog.model.article.ArticleType;
import com.jiayeli.blog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleTypeImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public boolean addArticleType(ArticleType blogArticle) {
        return articleTypeMapper.insert(blogArticle)>0?true:false;
    }

    @Override
    public boolean deleteArticleType(String id) {
        return articleTypeMapper.deleteByPrimaryKey(id)>0?true:false;
    }

    @Override
    public boolean updateArticleType(ArticleType ArticleType) {
        return articleTypeMapper.updateByPrimaryKey(ArticleType)>0?true:false;
    }

    @Override
    public ArticleType getArticleTypeByid(String id) {
        return articleTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ArticleType> getAllArticleType() {
        return articleTypeMapper.selectAll();
    }

    @Override
    public List getTypes() {
        return articleTypeMapper.selectTypes();
    }
}
