package com.jiayeli.blog.control;

import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.common.response.ResponseEnums;
import com.jiayeli.blog.model.SelfIntro;
import com.jiayeli.blog.service.BlogSystemManageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("systemManage")
@Controller
@CrossOrigin
public class BlogSysManage {

    @Autowired
    private BlogSystemManageSer ser;

    @PostMapping("updateSelfIntro")
    @ResponseBody
    public CommonResponseType updateSelfIntro(@RequestBody SelfIntro selfIntro) {
        boolean b = ser.updateSelfIntro(selfIntro);
        if (b)
            return CommonResponseType.ok(b);
        return CommonResponseType.error(ResponseEnums.ADD_OR_UPDATE_ERRO);
    }

    @GetMapping("getIntroById")
    @ResponseBody
    public CommonResponseType getIntro() {
        int id = 1;
        SelfIntro selfIntro = ser.getIntroById(id);
        if (selfIntro == null)
            return CommonResponseType.error(ResponseEnums.EXECUTOR_ERROR, "获取个人信息失败");
        return CommonResponseType.ok(selfIntro);
    }



}
