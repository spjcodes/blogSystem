package com.jiayeli.blog.control;

import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.common.response.CommonResponse;
import com.jiayeli.blog.common.response.ResponseEnums;
import com.jiayeli.blog.erros.BusinessException;
import com.jiayeli.blog.erros.CommonErroEum;
import com.jiayeli.blog.model.ArticleType;
import com.jiayeli.blog.service.ArticleTypeSer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("ArticleType")
@Controller
@CrossOrigin
public class ArticleTypeControl {


    @Autowired
    private ArticleTypeSer articleTypeSer;

    @PostMapping("addArticleType")
    @ResponseBody
    public CommonResponseType addArticleType(@RequestBody ArticleType articleType) throws BusinessException {
      
        boolean b = articleTypeSer.addArticleType(articleType);
        if(!b)
            return CommonResponseType.error(ResponseEnums.ADD_OR_UPDATE_ERRO, "博文类型添加失败");
        return CommonResponseType.ok(b);
    }

    @GetMapping("getTypes")
    @ResponseBody
    public CommonResponseType getTypes() {
        List types = this.articleTypeSer.getTypes();
        return CommonResponseType.ok(types);
    }

    @PostMapping("updateArticleType")
    @ResponseBody
    public CommonResponseType updateArticleType(@RequestBody ArticleType articleType) throws BusinessException {

        boolean b = articleTypeSer.updateArticleType(articleType);
        if (!b)
            return CommonResponseType.error(ResponseEnums.ADD_OR_UPDATE_ERRO);
        return CommonResponseType.ok(b);
    }

    @PostMapping("deleteArticleType")
    @ResponseBody
    public CommonResponseType deleteArticleType(@RequestBody ArticleType articleType) throws BusinessException {
        if(StringUtils.isEmpty(articleType.getId()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = articleTypeSer.deleteArticleType(articleType.getId());
        if(!b)
            return CommonResponseType.error(ResponseEnums.DELETE_ERRO);
        return CommonResponseType.ok(b);
    }

    @GetMapping("getArticleTypeList")
    @ResponseBody
    public CommonResponseType getArticleTypes() {
        List<ArticleType> allArticleType = articleTypeSer.getAllArticleType();
        return CommonResponseType.ok(allArticleType);
    }

    @PostMapping("getArticleTypeById")
    @ResponseBody
    public CommonResponseType getArticleById(@RequestBody ArticleType articleType) {
        ArticleType type = articleTypeSer.getArticleTypeByid(articleType.getId());
        return CommonResponseType.ok(type);
    }
}
