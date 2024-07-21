package com.jiayeli.blog.dao;

import com.jiayeli.blog.model.Resumer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resumer record);

    int insertSelective(Resumer record);

    Resumer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resumer record);

    int updateByPrimaryKey(Resumer record);

    Resumer getResumerById(String id);

    List<Resumer> getResumerList();
}