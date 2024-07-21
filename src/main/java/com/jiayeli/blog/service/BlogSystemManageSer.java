package com.jiayeli.blog.service;

import com.jiayeli.blog.model.SelfIntro;

public interface BlogSystemManageSer {

    public boolean updateSelfIntro(SelfIntro selfIntro);

    SelfIntro getIntroById(int id);
}
