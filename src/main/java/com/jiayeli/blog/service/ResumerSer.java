package com.jiayeli.blog.service;

import com.jiayeli.blog.model.Resumer;

import java.util.List;

public interface ResumerSer {

    public boolean addResumer(Resumer resumer);

    public boolean updateResumer(Resumer resumer);

    public Resumer getResumer(String id);

    public List<Resumer> getResumerList();

    public boolean deleteResumerById(String id);


}
