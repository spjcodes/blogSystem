package com.jiayeli.blog.control.base;

import com.jiayeli.blog.erros.BusinessException;
import com.jiayeli.blog.erros.CommonErroEum;
import com.jiayeli.blog.validator.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseControl {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception e) {

        System.out.println("into handle exception");
        CommonReturnType commonReturnType = new CommonReturnType();
        Map m = new HashMap<>();

        if(e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            commonReturnType.setStatus("fail");
            commonReturnType.setObject(e);
            m.put("erroCode",businessException.getErroCode());
            m.put("erroMsg", businessException.getErroMsg());
        } else {
            m.put("erroCode", CommonErroEum.UNKONW_ERRO.getErroCode());
            m.put("erroMsg",e.getMessage());
            System.out.println("e.getstacktrace" + e.getStackTrace());
            System.out.println("e.getstacktrace" + e.getLocalizedMessage());
            System.out.println("e.getstacktrace" + e.getCause());
            System.out.println("e.getstacktrace" + e.getMessage());

        }
        return CommonReturnType.create("faild", m);
    }
}
