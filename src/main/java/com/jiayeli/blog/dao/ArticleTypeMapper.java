package com.jiayeli.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiayeli.blog.model.ArticleType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTypeMapper extends BaseMapper<ArticleType> {
    int deleteByPrimaryKey(String id);

    int insert(ArticleType record);
// 
    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);

    List<ArticleType> selectAll();

    List selectTypes();
}