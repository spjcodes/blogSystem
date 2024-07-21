package com.jiayeli.blog.erros;

import lombok.AllArgsConstructor;

/**
 * 统一错误类型（枚举）
 */
@AllArgsConstructor
public enum  CommonErroEum implements CommonErro {

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


    ;

    private int erroCode;

    private String erroMsg;

    @Override
    public int getErroCode() {
        return erroCode;
    }

    @Override
    public String getErroMsg() {
        return erroMsg;
    }

    @Override
    public CommonErro setErroMsg(String erroMsg) {
        this.erroMsg = erroMsg;
        return this;
    }
}
