package com.jiayeli.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiayeli.blog.model.RecommendModel;

public interface RecommendMapper extends BaseMapper<RecommendModel> {
    int deleteByPrimaryKey(String id);

    int insert(RecommendModel record);

    int insertSelective(RecommendModel record);

    RecommendModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RecommendModel record);

    int updateByPrimaryKey(RecommendModel record);
}