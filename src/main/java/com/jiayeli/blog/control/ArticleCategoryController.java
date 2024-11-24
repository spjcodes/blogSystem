package com.jiayeli.blog.control;

import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.control.base.BaseControl;
import com.jiayeli.blog.service.ArticleCategoryService;
import com.jiayeli.blog.service.ArticleService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kuro@jiayeli.cn
 * @since 2024-11-23 21:19:48
 */
@Controller
@RequestMapping("articleCategory")
@Schema(name = "ArticleCategoryController", description = "articleCategory controller")
public class ArticleCategoryController extends BaseControl {
    @Autowired
    private ArticleCategoryService articleCategoryService;

    @RequestMapping("getArticleCategoryListByAuthorId")
    @ResponseBody
    public CommonResponseType getArticleCategoryList(String authorId) {
        return CommonResponseType.ok(articleCategoryService.getArticleCategoryListByAuthorId(authorId));
    }
}
