package com.jiayeli.blog.dao;

import com.jiayeli.blog.model.SelfIntro;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfIntroMapper {
    int insert(SelfIntro record);

    int insertSelective(SelfIntro record);

    int updateSelfIntro(SelfIntro selfIntro);

    SelfIntro getSelfIntro(int id);
}