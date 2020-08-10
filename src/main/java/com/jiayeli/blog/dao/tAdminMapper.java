package com.jiayeli.blog.dao;

import com.jiayeli.blog.model.tAdmin;

public interface tAdminMapper {
    int insert(tAdmin record);

    int insertSelective(tAdmin record);
}