package com.jiayeli.blog.control;

import com.jiayeli.blog.erros.BusinessException;
import com.jiayeli.blog.erros.CommonErroEum;
import com.jiayeli.blog.model.ArticleType;
import com.jiayeli.blog.service.ArticleTypeSer;
import com.jiayeli.blog.validator.CommonReturnType;
import com.jiayeli.blog.validator.ValidationResult;
import com.jiayeli.blog.validator.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RequestMapping("ArticleType")
@Controller
@CrossOrigin
public class ArticleTypeControl {

    @Resource
    private ValidatorImpl validator;

    @Autowired
    private ArticleTypeSer articleTypeSer;

    @PostMapping("addArticleType")
    @ResponseBody
    public CommonReturnType addArticleType(@RequestBody ArticleType articleType) throws BusinessException {
        ValidationResult result = this.validator.validator(articleType);
        if (result.isHasErros())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = articleTypeSer.addArticleType(articleType);
        if(!b)
            return CommonReturnType.create("faild", CommonErroEum.UNKONW_ERRO.setErroMsg("博文类型添加失败"));
        return CommonReturnType.create(b);
    }

    @GetMapping("getTypes")
    @ResponseBody
    public CommonReturnType getTypes() {
        List types = this.articleTypeSer.getTypes();
        return CommonReturnType.create(types);
    }

    @PostMapping("updateArticleType")
    @ResponseBody
    public CommonReturnType updateArticleType(@RequestBody ArticleType articleType) throws BusinessException {
        ValidationResult result = this.validator.validator(articleType);
        if(result.isHasErros())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = articleTypeSer.updateArticleType(articleType);
        if (!b)
            return CommonReturnType.create("faild", CommonErroEum.ADD_OR_UPDATE_ERRO);
        return CommonReturnType.create(b);
    }

    @PostMapping("deleteArticleType")
    @ResponseBody
    public CommonReturnType deleteArticleType(@RequestBody ArticleType articleType) throws BusinessException {
        if(StringUtils.isEmpty(articleType.getId()))
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = articleTypeSer.deleteArticleType(articleType.getId());
        if(!b)
            return CommonReturnType.create("faild", CommonErroEum.DELETE_ERRO);
        return CommonReturnType.create(b);
    }

    @GetMapping("getArticleTypeList")
    @ResponseBody
    public CommonReturnType getArticleTypes() {
        List<ArticleType> allArticleType = articleTypeSer.getAllArticleType();
        return CommonReturnType.create(allArticleType);
    }

    @PostMapping("getArticleTypeById")
    @ResponseBody
    public CommonReturnType getArticleById(@RequestBody ArticleType articleType) {
        ArticleType type = articleTypeSer.getArticleTypeByid(articleType.getId());
        if (type != null)
            return CommonReturnType.create(type);
        else
            return CommonReturnType.create("faild", type);
    }
}
