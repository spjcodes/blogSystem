package com.jiayeli.blog.dao;

import com.jiayeli.blog.model.tAdmin;
import org.springframework.stereotype.Repository;

public interface tAdminMapper {
    int insert(tAdmin record);

    int insertSelective(tAdmin record);
}