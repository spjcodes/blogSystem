package com.jiayeli.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiayeli.blog.model.ArticleModel;
import com.jiayeli.blog.model.BlogArticle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper extends BaseMapper<ArticleModel> {
/*    int deleteByPrimaryKey(String id);

    int insert(ArticleModel record);

    int insertSelective(ArticleModel record);

    ArticleModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlogArticle record);

    int updateByPrimaryKey(ArticleModel record);

    List<ArticleModel> selectArticlesByType(String type);

    List<ArticleModel> selectAllBlogArticles();*/

    void visitsCount(String id);
}