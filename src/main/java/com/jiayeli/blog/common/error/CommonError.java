package com.jiayeli.blog.common.error;

/**
 * @author: jiayeli.cn
 * @description common errors
 * @date: 2022/9/11 下午10:04
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
