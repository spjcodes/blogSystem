package com.jiayeli.blog.control;

import com.jiayeli.blog.control.base.BaseControl;
import com.jiayeli.blog.erros.BusinessException;
import com.jiayeli.blog.erros.CommonErroEum;
import com.jiayeli.blog.model.BlogArticle;
import com.jiayeli.blog.service.BlogArticleSer;
import com.jiayeli.blog.validator.CommonReturnType;
import com.jiayeli.blog.validator.ValidationResult;
import com.jiayeli.blog.validator.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("blogArticle")
@Controller
@CrossOrigin
public class BlogArticleCon extends BaseControl {

    @Resource
    private ValidatorImpl validator;

    @Autowired
    private BlogArticleSer blogArticleSer;

    @PostMapping("addBlogArticle")
    @ResponseBody
    public CommonReturnType addBlogArticle(@RequestBody BlogArticle blogArticle) throws BusinessException {
        //差数校验
        ValidationResult result = this.validator.validator(blogArticle);
        boolean flag = blogArticleSer.addBlogArticle(blogArticle);
        if(!flag)
            throw new BusinessException(CommonErroEum.UNKONW_ERRO);
        if (result.isHasErros())
            return CommonReturnType.create("faild",
                   result.getErroMag());

        return CommonReturnType.create(flag);
    }

    @PostMapping("updateBlogArtcle")
    @ResponseBody
    public CommonReturnType updateBlogArtcle(@RequestBody BlogArticle blogArticle) throws BusinessException {
        ValidationResult result = this.validator.validator(blogArticle);
        if (result.isHasErros())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = blogArticleSer.updateBlogArticle(blogArticle);
        if(!b)
            return CommonReturnType.create("faild", "修改博文失败!");
        return CommonReturnType.create(b);
    }

    @PostMapping("deleteBlogArtcle")
    @ResponseBody
    public CommonReturnType deleteBlogArtcle(@RequestBody BlogArticle blogArticle) throws BusinessException {
        if(StringUtils.isEmpty(blogArticle.getId()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = blogArticleSer.deleteBlogArticle(blogArticle.getId());
        if(!b)
            return CommonReturnType.create("faild", "删除博文失败");
        return CommonReturnType.create(b);
    }

    @PostMapping("getBlogsArtcleById")
    @ResponseBody
    public CommonReturnType getBlogsArtcleById(@RequestBody BlogArticle blogArticle) throws BusinessException {
        if(StringUtils.isEmpty(blogArticle.getId()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        BlogArticle bloArticle = blogArticleSer.getBlogArticleById(blogArticle.getId());
        return CommonReturnType.create(bloArticle);
    }


    @PostMapping("getBlogsArticleByType")
    @ResponseBody
    public CommonReturnType getBlogsArticleByType(@RequestBody BlogArticle blogArticle) throws BusinessException {
        if(StringUtils.isEmpty(blogArticle.getTypeid()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        List<BlogArticle> bls = blogArticleSer.getBlogArticlesByType(blogArticle.getTypeid());
        return CommonReturnType.create(bls);
    }


    @GetMapping("getBlogArticleList")
    @ResponseBody
    public CommonReturnType getBlogArticleList() throws BusinessException {
        List<BlogArticle> allBlogArticles = blogArticleSer.getAllBlogArticles();
        return CommonReturnType.create(allBlogArticles);
    }


    @Value("${spring.resources.static-locations}")
    String filePath;


    @PostMapping("uploadFile")
    @ResponseBody
    public CommonReturnType uploadFile(MultipartFile multFile) throws BusinessException {
        if (multFile.isEmpty())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        Map map = this.blogArticleSer.fileUpload(filePath.split(":")[1], multFile);
        if (map.isEmpty())
            return CommonReturnType.create("faild", "文件存储失败");
        return CommonReturnType.create(map);
    }

    @RequestMapping("ckeditorUpload")
    @ResponseBody
    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {
        return this.blogArticleSer.ckeditUpload(file, CKEditorFuncNum);
    }

    @PostMapping("visitsCount")
    @ResponseBody
    public void visitsCount(@RequestBody BlogArticle blogArticle) {
        this.blogArticleSer.visitsCount(blogArticle.getId());
    }



}
