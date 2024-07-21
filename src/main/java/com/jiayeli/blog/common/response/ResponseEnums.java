package com.jiayeli.blog.common.response;


import com.jiayeli.blog.common.error.CommonError;

public enum ResponseEnums implements CommonResponse, CommonError {

    //10000 用户相关
    USER_NOTE_EXISTS(10001,"用户不存在"),
    VERIFICATION_CODE_ERRO(10002, "验证码错误"),
    USERNAMW_OR_PASSwoRD_ERRO(10003,"密码或用户名错误"),
    USER_LOGIN_FAILD(10004,"登陆失败用户尚未注册"),

    //20000 通用错误类型
    PARAMETER_NOT_VALID(20001, "差数不合法"),
    UNKONW_ERRO(20002, "未知错误"),

    //30000 业务相关错误类型
    ADD_OR_UPDATE_ERRO(30001, "添加或修改数据出错"),
    DELETE_ERRO (30002, "删除数据失败"),

    SUCCESS(200000, "success"),
    TIMEOUT(300000, "timeout"),
    PARAMETER_ERROR(400000, "parameter error"),
    UNKNOWN_ERROR(500000, "unknown error."),
    EXECUTOR_ERROR(400001, "executor error"),
    SERVERS_DB_ERROR(500001, "sqlQuery or DB error" );

    private final int code;
    private String desc;

    ResponseEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getResponseCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int getErrCode() {
        return getResponseCode();
    }

    @Override
    public String getErrMsg() {
        return getDesc();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        setDesc(errMsg);
        return this;
    }
}
