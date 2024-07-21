package com.jiayeli.blog.common.error;


import com.jiayeli.blog.common.response.CommonResponse;

/**
 * @author: jiayeli.cn
 * @description platform exception
 * @date: 2022/9/11 下午9:14
 */
public class PlatformException extends Exception implements CommonError, CommonResponse {

    private final CommonError commonError;

    public PlatformException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public PlatformException(CommonError commonError, String errorMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errorMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        return this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getResponseCode() {
        return getErrCode();
    }

    @Override
    public String getDesc() {
        return getErrMsg();
    }

    @Override
    public void setDesc(String desc) {
        setErrMsg(desc);
    }

    @Override
    public String toString() {
        return "[PlatformException]\t{" +
                "errorCode=" + commonError.getErrCode() + "\t" +
                "errorMsg=" + commonError.getErrMsg() +
                '}';
    }
}
