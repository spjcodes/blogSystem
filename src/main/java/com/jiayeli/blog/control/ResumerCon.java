package com.jiayeli.blog.control;

import com.jiayeli.blog.erros.BusinessException;
import com.jiayeli.blog.erros.CommonErro;
import com.jiayeli.blog.erros.CommonErroEum;
import com.jiayeli.blog.model.Resumer;
import com.jiayeli.blog.service.ResumerSer;
import com.jiayeli.blog.validator.CommonReturnType;
import com.jiayeli.blog.validator.ValidationResult;
import com.jiayeli.blog.validator.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("resumer")
//@CrossOrigin
@Controller
public class ResumerCon {

    @Autowired
    private ResumerSer resumerSer;

    @Autowired
    private ValidatorImpl validator;

    @PostMapping("addResumer")
    @ResponseBody
    public CommonReturnType addResumer(@RequestBody Resumer resumer) throws BusinessException {

        ValidationResult validationResult = this.validator.validator(resumer);
        if (validationResult.isHasErros()){
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        }

        boolean b = resumerSer.addResumer(resumer);
        if (b)
            return CommonReturnType.create(b);
        else
            return CommonReturnType.create("faild", "新加个人信息失败");

    }

    @PostMapping("updateResumer")
    @ResponseBody
    public CommonReturnType uddateResumer(@RequestBody Resumer resumer) throws BusinessException {
        ValidationResult validationResult = this.validator.validator(resumer);
        if (validationResult.isHasErros())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = resumerSer.updateResumer(resumer);
        if (b)
            return CommonReturnType.create(b);
        else
            return CommonReturnType.create("faild", "修改个人信息失败");
    }

    @PostMapping("deleteResumerById")
    @ResponseBody
    public CommonReturnType deleteResumerById(@RequestBody Resumer resumer) throws BusinessException {
        ValidationResult validationResult = this.validator.validator(resumer);
        if (validationResult.isHasErros())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        boolean b = resumerSer.deleteResumerById(resumer.getId());
        if (b)
            return CommonReturnType.create(b);
        else
            return CommonReturnType.create("faild", "修改信息失败");
    }

    @PostMapping("getResumerById")
    @ResponseBody
    public CommonReturnType getResumerById(@RequestBody Resumer resumer) throws BusinessException {
        ValidationResult validationResult = this.validator.validator(resumer);
        if (validationResult.isHasErros())
            throw new BusinessException(CommonErroEum.PARAMETER_NOT_VALID);
        return CommonReturnType.create(resumerSer.getResumer(resumer.getId()));
    }

    @GetMapping("getResumerList")
    @ResponseBody
    public CommonReturnType getResumerList() {
        return CommonReturnType.create(resumerSer.getResumerList());
    }

}
