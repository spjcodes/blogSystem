package com.jiayeli.blog.service.impl;

import com.jiayeli.blog.dao.ResumerMapper;
import com.jiayeli.blog.model.Resumer;
import com.jiayeli.blog.service.ResumerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumerImpl implements ResumerSer {

    @Autowired
    private ResumerMapper resumerDao;

    @Override
    public boolean addResumer(Resumer resumer) {
        int i = 0;
        try {
            i = resumerDao.insertSelective(resumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateResumer(Resumer resumer) {

        try {
            int i = resumerDao.updateByPrimaryKey(resumer);
            if (i>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Resumer getResumer(String id) {
        return resumerDao.getResumerById(id);
    }

    @Override
    public List<Resumer> getResumerList() {
        return resumerDao.getResumerList();
    }

    @Override
    public boolean deleteResumerById(String id) {
        try {
            int i = resumerDao.deleteByPrimaryKey(id);
            if (i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
