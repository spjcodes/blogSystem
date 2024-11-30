package com.jiayeli.blog.control.base;

import com.jiayeli.blog.common.CommonResponseType;
import com.jiayeli.blog.common.error.PlatformException;
import com.jiayeli.blog.common.response.ResponseEnums;
import com.jiayeli.blog.common.utils.logger.LoggerUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.UndeclaredThrowableException;

@Slf4j
public class BaseControl {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object exceptionHandle(HttpServletRequest request, Exception e) {
        CommonResponseType commonReturnType  = new CommonResponseType();

        if(e instanceof PlatformException) {
            PlatformException platformException = (PlatformException) e;
            commonReturnType.setStatus(platformException.getErrCode());
            commonReturnType.setDesc(platformException.getErrMsg());
            log.error(commonReturnType.toString());
        } else if(e instanceof UndeclaredThrowableException){
            UndeclaredThrowableException undeclaredThrowable = (UndeclaredThrowableException) e;
            if ((undeclaredThrowable.getUndeclaredThrowable() instanceof PlatformException)) {
                PlatformException platformException = (PlatformException) undeclaredThrowable.getUndeclaredThrowable();
                commonReturnType.setStatusCode(platformException.getErrCode());
                commonReturnType.setDesc(platformException.getErrMsg());
                log.error("error: " + platformException);
            } else {
                commonReturnType.setStatus(ResponseEnums.UNKNOWN_ERROR.getStatusCode());
                commonReturnType.setDesc(undeclaredThrowable.getUndeclaredThrowable().getMessage());
                log.error(LoggerUtils.undeclaredThrowableExceptionInfoExtract(undeclaredThrowable));
            }
        } else {
            commonReturnType.setStatus(ResponseEnums.UNKNOWN_ERROR.getStatusCode());
            commonReturnType.setDesc(e.getMessage());
            log.error(LoggerUtils.errorInfoExtract(e));
        }
        e.printStackTrace();
        System.out.println(request);
        return commonReturnType;

    }
}