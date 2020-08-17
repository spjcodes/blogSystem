package com.jiayeli.blog.service.impl;

import com.jiayeli.blog.dao.BlogArticleMapper;
import com.jiayeli.blog.model.BlogArticle;
import com.jiayeli.blog.service.BlogArticleSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogArticleImpl implements BlogArticleSer {

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    @Override
    public boolean addBlogArticle(BlogArticle blogArticle) {
        try {
            blogArticle.setCreatetime(new Date(System.currentTimeMillis()));
            blogArticleMapper.insertSelective(blogArticle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBlogArticle(String id) {
        int i = blogArticleMapper.deleteByPrimaryKey(id);
        return i>0?true:false;
    }

    @Override
    public boolean updateBlogArticle(BlogArticle blogArticle) {
        blogArticle.setCreatetime((Date.from(Instant.ofEpochSecond(System.currentTimeMillis()))));
        int i = blogArticleMapper.updateByPrimaryKey(blogArticle);
        return i>0?true:false;
    }

    @Override
    public BlogArticle getBlogArticleById(String id) {
        BlogArticle blogArticle = blogArticleMapper.selectByPrimaryKey(id);
        return blogArticle;
    }

    @Override
    public List<BlogArticle> getBlogArticlesByType(String type) {

        return blogArticleMapper.selectArticlesByType(type);
    }

    @Override
    public List<BlogArticle> getAllBlogArticles() {

        return blogArticleMapper.selectAllBlogArticles();
    }

    /**
     *将文件存储到指定位置，返回存储的文件名
     * @param filePath  文件的存储路径
     * @param uploadFile 上传的文件
     * @return 存储的新文件名
     */
    public Map fileUpload(String filePath, MultipartFile uploadFile) {
        Map m = null;
        //获取原来的文件名，得到后缀为生成新文件名使用
        String fileName = uploadFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        //生成新文件名
        fileName = String.valueOf(System.currentTimeMillis() + fileSuffix);

        //判断存储文件的目标文件夹是否存在不存在则生成
        File tf = new File(filePath);
        if (!tf.exists()){
            tf.mkdir();
        }

        //将文件存储到本地硬盘并将信息（文件名）返回
        try {
            uploadFile.transferTo(new File(filePath, fileName));
            m = new HashMap();
            m.put("fileName", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return m;
    }
}
