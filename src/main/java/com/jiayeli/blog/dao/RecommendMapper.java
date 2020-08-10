package com.jiayeli.blog.dao;

import com.jiayeli.blog.model.Recommend;

public interface RecommendMapper {
    int deleteByPrimaryKey(String id);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    Recommend selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}