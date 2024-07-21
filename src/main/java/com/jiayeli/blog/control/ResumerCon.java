package com.jiayeli.blog.control;

import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.common.response.ResponseEnums;
import com.jiayeli.blog.control.base.BaseControl;
import com.jiayeli.blog.erros.BusinessException;
import com.jiayeli.blog.erros.CommonErroEum;
import com.jiayeli.blog.model.Resumer;
import com.jiayeli.blog.service.ResumerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("resumer")
//@CrossOrigin
@Controller
public class ResumerCon extends BaseControl {

    @Autowired
    private ResumerSer resumerSer;


    @PostMapping("addResumer")
    @ResponseBody
    public CommonResponseType addResumer(@RequestBody Resumer resumer) throws BusinessException {

        boolean b = resumerSer.addResumer(resumer);
        if (b)
            return CommonResponseType.ok(b);
        else
            return CommonResponseType.error(ResponseEnums.ADD_OR_UPDATE_ERRO, "新加个人信息失败");

    }

    @PostMapping("updateResumer")
    @ResponseBody
    public CommonResponseType uddateResumer(@RequestBody Resumer resumer) throws BusinessException {

        boolean b = resumerSer.updateResumer(resumer);
        return CommonResponseType.ok(b);
    }

    @PostMapping("deleteResumerById")
    @ResponseBody
    public CommonResponseType deleteResumerById(@RequestBody Resumer resumer) throws BusinessException {

        boolean b = resumerSer.deleteResumerById(resumer.getId());
        return CommonResponseType.ok(b);
    }

    @PostMapping("getResumerById")
    @ResponseBody
    public CommonResponseType getResumerById(@RequestBody Resumer resumer) throws BusinessException {
        return CommonResponseType.ok(resumerSer.getResumer(resumer.getId()));
    }

    @GetMapping("getResumerList")
    @ResponseBody
    public CommonResponseType getResumerList() {
        return CommonResponseType.ok(resumerSer.getResumerList());
    }

}
