package com.jiayeli.blog.dao;

import com.jiayeli.blog.model.BlogArticle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogArticle record);

    int insertSelective(BlogArticle record);

    BlogArticle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogArticle record);

    int updateByPrimaryKey(BlogArticle record);

    List<BlogArticle> selectArticlesByType(String type);

    List<BlogArticle> selectAllBlogArticles();

    void visitsCount(String id);
}