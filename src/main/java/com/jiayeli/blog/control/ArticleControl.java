package com.jiayeli.blog.control;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.common.response.ResponseEnums;
import com.jiayeli.blog.control.base.BaseControl;
import com.jiayeli.blog.dao.CommentsMapper;
import com.jiayeli.blog.dto.ArticleDto;
import com.jiayeli.blog.erros.BusinessException;
import com.jiayeli.blog.erros.CommonErroEum;
import com.jiayeli.blog.model.BlogArticle;
import com.jiayeli.blog.model.article.ArticleModel;
import com.jiayeli.blog.service.ArticleService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RequestMapping("article")
@Controller
@CrossOrigin
public class ArticleControl extends BaseControl {

    @Autowired
    private ArticleService articleSer;

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
//    private TagsMapper tagsMapper;

    @GetMapping("test")
    @ResponseBody
    public CommonResponseType test() {
        return CommonResponseType.ok(articleSer.list());
    }

    @PostMapping("addArticle")
    @ResponseBody
    public CommonResponseType addArticle(@RequestBody ArticleDto articleDto) throws BusinessException {

        boolean flag = articleSer.addBlogArticle(convert2ArticleModel(articleDto));
        if(!flag)
            throw new BusinessException(CommonErroEum.UNKONW_ERRO);

        return CommonResponseType.ok(flag);
    }

    @PostMapping("updateBlogArticle")
    @ResponseBody
    public CommonResponseType updateArticle(@RequestBody ArticleModel blogArticle) throws BusinessException {

        boolean b = articleSer.update(blogArticle, new LambdaUpdateWrapper<ArticleModel>()
                .eq(ArticleModel::getId, blogArticle.getId()));
        if(!b)
            return CommonResponseType.create(CommonErroEum.ADD_OR_UPDATE_ERRO.getErroCode(), "修改博文失败!");
        return CommonResponseType.ok(b);
    }

    @PostMapping("deleteBlogArticle")
    @ResponseBody
    public CommonResponseType deleteBlogArticle(@RequestBody BlogArticle blogArticle) throws BusinessException {
        if(StringUtils.isEmpty(blogArticle.getId()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = articleSer.deleteBlogArticle(blogArticle.getId());
        if(!b)
            return CommonResponseType.error(ResponseEnums.ADD_OR_UPDATE_ERRO, "删除博文失败");
        return CommonResponseType.ok(b);
    }

    @PostMapping("getArticleById")
    @ResponseBody
    public CommonResponseType getArticleById(@RequestBody String articleId) throws BusinessException {
        if(StringUtils.isEmpty(articleId))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        ArticleModel bloArticle = articleSer.getArticleById(articleId);
        return CommonResponseType.ok(bloArticle);
    }
    @PostMapping("getArticleByIds")
    @ResponseBody
    public CommonResponseType getArticleByIds(@RequestBody List<String> articleIdList) throws BusinessException {
        if(ObjectUtils.isEmpty(articleIdList))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        List<ArticleModel> bloArticles = articleSer.getArticleByIds(articleIdList);
        return CommonResponseType.ok(bloArticles);
    }

    @PostMapping("getBlogsArticleByType")
    @ResponseBody
    public CommonResponseType getBlogsArticleByType(@RequestBody BlogArticle blogArticle) throws BusinessException {
        if(StringUtils.isEmpty(blogArticle.getTypeid()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        List<ArticleModel> bls = articleSer.getArticleList(blogArticle.getTypeid());
        return CommonResponseType.ok(bls);
    }


    @GetMapping("getArticleList")
    @ResponseBody
    public CommonResponseType getArticleList() throws BusinessException {
        List<ArticleModel> allBlogArticles = articleSer.getArticleList();
        return CommonResponseType.ok(allBlogArticles);
    }


    @Value("${spring.resources.static-locations}")
    String filePath;

    @PostMapping("pic")
    public CommonResponseType updatePic(@RequestParam("file") MultipartFile file, @RequestParam("id") int id){
        System.out.println(file + "  id: " +id);
        return null;
    }

    @PostMapping("uploadFile")
    @ResponseBody
    public CommonResponseType uploadFile(@RequestParam("file") MultipartFile fileList) throws BusinessException {
        if (fileList.isEmpty())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        Map<String, String> map = this.articleSer.fileUpload(filePath.split(":")[1], fileList);
        if (map.isEmpty())
            return CommonResponseType.error(ResponseEnums.ADD_OR_UPDATE_ERRO, "文件存储失败");
        return CommonResponseType.ok(map);
    }

    @RequestMapping("ckeditorUpload")
    @ResponseBody
    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {
        return this.articleSer.ckeditUpload(file, CKEditorFuncNum);
    }

    @PostMapping("visitsCount")
    @ResponseBody
    public void visitsCount(@RequestBody BlogArticle blogArticle) {
        this.articleSer.visitsCount(blogArticle.getId());
    }

    private ArticleModel convert2ArticleModel(ArticleDto articleDto) {
        ArticleModel articleModel = new ArticleModel();
        BeanUtils.copyProperties(articleDto, articleModel);
        String tagIds = String.join("|",articleDto.getTags());
        articleModel.setTagIds(tagIds);
        return articleModel;
    }
}
