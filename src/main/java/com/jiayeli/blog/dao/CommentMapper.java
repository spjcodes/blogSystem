package com.jiayeli.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiayeli.blog.model.CommentsModel;

public interface CommentMapper extends BaseMapper<CommentsModel> {
    int deleteByPrimaryKey(String id);

    int insert(CommentsModel record);

    int insertSelective(CommentsModel record);

    CommentsModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommentsModel record);

    int updateByPrimaryKey(CommentsModel record);
}