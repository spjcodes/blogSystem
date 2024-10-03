package com.jiayeli.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiayeli.blog.dao.ArticleMapper;
import com.jiayeli.blog.model.ArticleModel;
import com.jiayeli.blog.service.ArticleSer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleSerImpl  extends ServiceImpl<ArticleMapper, ArticleModel> implements ArticleSer {

    @Autowired
    private ArticleMapper articleMapper;

    @Value("spring.resource.static-locations")
    private String filePath;

    @Override
    public boolean addBlogArticle(ArticleModel blogArticle) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            blogArticle.setCreatedAt(timestamp);
            articleMapper.insert(blogArticle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBlogArticle(String id) {
        int i = articleMapper.deleteById(id);
        return i>0?true:false;
    }

    @Override
    public boolean updateBlogArticle(ArticleModel blogArticle) {
        int i = articleMapper
                .update(blogArticle, new LambdaUpdateWrapper<ArticleModel>()
                .eq(StringUtils.isNotBlank(blogArticle.getId()),ArticleModel::getId, "1"));
        return i > 0;
    }

    @Override
    public ArticleModel getArticleById(String id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<ArticleModel> getArticleList(String type) {

        return articleMapper
                .selectList(new LambdaQueryWrapper<ArticleModel>()
                .eq(ArticleModel::getCategoryId, type));
    }

    @Override
    public List<ArticleModel> getArticleList() {

        return articleMapper.selectList(null);
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
        fileName = System.currentTimeMillis() + fileSuffix;

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

    @Override
    public void visitsCount(String id) {
        this.articleMapper.visitsCount(id);
//        articleMapper.update(new LambdaUpdateWrapper<ArticleModel>().set(ArticleModel::getViewCount, id));
    }

    public String ckeditUpload(MultipartFile file, String ckEditorFuncNum) {
        if (!file.isEmpty()) {
            String finename=file.getOriginalFilename();
            String suffixname=file.getOriginalFilename().substring(finename.lastIndexOf("."));
            finename= System.currentTimeMillis() +suffixname;
            File tf=new File(filePath);
            if(!tf.exists()){
                tf.mkdir();
            }
            String savefile=filePath+finename;
            try {
                file.transferTo(new File(savefile));
                String url="http://localhost:8080/"+finename;
                return "{\"uploaded\":1,\"fileName\":\""+savefile+"\",\"url\":\"" + url + "\"}";
            } catch (IOException e) {
                e.printStackTrace();
                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";

            } catch (IllegalStateException e) {
                e.printStackTrace();
                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
            }
        }
        return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
    }
}
