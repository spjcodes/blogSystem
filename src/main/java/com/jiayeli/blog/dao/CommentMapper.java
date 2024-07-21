package com.jiayeli.blog.dao;

import com.jiayeli.blog.model.Comment;
import org.springframework.stereotype.Repository;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}