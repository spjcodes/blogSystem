package com.jiayeli.blog.control;

import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.common.response.ResponseEnums;
import com.jiayeli.blog.control.base.BaseControl;
import com.jiayeli.blog.erros.BusinessException;
import com.jiayeli.blog.erros.CommonErroEum;
import com.jiayeli.blog.model.BlogArticle;
import com.jiayeli.blog.service.BlogArticleSer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RequestMapping("blogArticle")
@Controller
@CrossOrigin
public class BlogArticleControl extends BaseControl {

    @Autowired
    private BlogArticleSer blogArticleSer;

    @PostMapping("addBlogArticle")
    @ResponseBody
    public CommonResponseType addBlogArticle(@RequestBody BlogArticle blogArticle) throws BusinessException {

        boolean flag = blogArticleSer.addBlogArticle(blogArticle);
        if(!flag)
            throw new BusinessException(CommonErroEum.UNKONW_ERRO);

        return CommonResponseType.ok(flag);
    }

    @PostMapping("updateBlogArtcle")
    @ResponseBody
    public CommonResponseType updateBlogArtcle(@RequestBody BlogArticle blogArticle) throws BusinessException {

        boolean b = blogArticleSer.updateBlogArticle(blogArticle);
        if(!b)
            return CommonResponseType.create(CommonErroEum.ADD_OR_UPDATE_ERRO.getErroCode(), "修改博文失败!");
        return CommonResponseType.ok(b);
    }

    @PostMapping("deleteBlogArtcle")
    @ResponseBody
    public CommonResponseType deleteBlogArtcle(@RequestBody BlogArticle blogArticle) throws BusinessException {
        if(StringUtils.isEmpty(blogArticle.getId()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = blogArticleSer.deleteBlogArticle(blogArticle.getId());
        if(!b)
            return CommonResponseType.error(ResponseEnums.ADD_OR_UPDATE_ERRO, "删除博文失败");
        return CommonResponseType.ok(b);
    }

    @PostMapping("getBlogsArtcleById")
    @ResponseBody
    public CommonResponseType getBlogsArtcleById(@RequestBody BlogArticle blogArticle) throws BusinessException {
        if(StringUtils.isEmpty(blogArticle.getId()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        BlogArticle bloArticle = blogArticleSer.getBlogArticleById(blogArticle.getId());
        return CommonResponseType.ok(bloArticle);
    }


    @PostMapping("getBlogsArticleByType")
    @ResponseBody
    public CommonResponseType getBlogsArticleByType(@RequestBody BlogArticle blogArticle) throws BusinessException {
        if(StringUtils.isEmpty(blogArticle.getTypeid()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        List<BlogArticle> bls = blogArticleSer.getBlogArticlesByType(blogArticle.getTypeid());
        return CommonResponseType.ok(bls);
    }


    @GetMapping("getBlogArticleList")
    @ResponseBody
    public CommonResponseType getBlogArticleList() throws BusinessException {
        List<BlogArticle> allBlogArticles = blogArticleSer.getAllBlogArticles();
        return CommonResponseType.ok(allBlogArticles);
    }


    @Value("${spring.resources.static-locations}")
    String filePath;

    @PostMapping("uploadFile")
    @ResponseBody
    public CommonResponseType uploadFile(MultipartFile multFile) throws BusinessException {
        if (multFile.isEmpty())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        Map map = this.blogArticleSer.fileUpload(filePath.split(":")[1], multFile);
        if (map.isEmpty())
            return CommonResponseType.error(ResponseEnums.ADD_OR_UPDATE_ERRO, "文件存储失败");
        return CommonResponseType.ok(map);
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
