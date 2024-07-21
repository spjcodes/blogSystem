package com.jiayeli.blog.service.impl;

import com.jiayeli.blog.dao.SelfIntroMapper;
import com.jiayeli.blog.model.SelfIntro;
import com.jiayeli.blog.service.BlogSystemManageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogSystemManageSerImpl implements BlogSystemManageSer {

    @Autowired
    private SelfIntroMapper selfIntroDao;

    @Override
    public boolean updateSelfIntro(SelfIntro selfIntro) {
        try {
            int f = selfIntroDao.updateSelfIntro(selfIntro);
            if (f>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public SelfIntro getIntroById(int id) {
        return selfIntroDao.getSelfIntro(id);
    }
}
