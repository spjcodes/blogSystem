package com.jiayeli.blog.service.impl;

import com.jiayeli.blog.dao.BlogArticleMapper;
import com.jiayeli.blog.model.BlogArticle;
import com.jiayeli.blog.service.BlogArticleSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogArticleImpl implements BlogArticleSer {

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    @Override
    public boolean addBlogArticle(BlogArticle blogArticle) {
        try {
            int i = blogArticleMapper.insertSelective(blogArticle);
            return i>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBlogArticle(String id) {
        int i = blogArticleMapper.deleteByPrimaryKey(id);
        return i>0?true:false;
    }

    @Override
    public boolean updateBlogArticle(BlogArticle blogArticle) {
        int i = blogArticleMapper.updateByPrimaryKey(blogArticle);
        return i>0?true:false;
    }

    @Override
    public BlogArticle getBlogArticleById(String id) {
        BlogArticle blogArticle = blogArticleMapper.selectByPrimaryKey(id);
        return blogArticle!=null?blogArticle:null;
    }

    @Override
    public List<BlogArticle> getBlogArticlesByType(String type) {
        return blogArticleMapper.selectArticlesByType(type);
    }

    @Override
    public List<BlogArticle> getAllBlogArticles() {
        return blogArticleMapper.selectAllBlogArticles();
    }
}
