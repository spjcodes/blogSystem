package com.jiayeli.blog.control;

import com.jiayeli.blog.model.SelfIntro;
import com.jiayeli.blog.service.BlogSystemManageSer;
import com.jiayeli.blog.validator.CommonReturnType;
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
    public CommonReturnType updateSelfIntro(@RequestBody SelfIntro selfIntro) {
        boolean b = ser.updateSelfIntro(selfIntro);
        if (b)
            return CommonReturnType.create(b);
        return CommonReturnType.create("faild", b);
    }

    @GetMapping("getIntroById")
    @ResponseBody
    public CommonReturnType getIntro() {
        int id = 1;
        SelfIntro selfIntro = ser.getIntroById(id);
        if (selfIntro == null)
            return CommonReturnType.create("faild", "获取个人信息失败");
        return CommonReturnType.create(selfIntro);
    }



}
