package com.jiayeli.blog.erros;

public class BusinessException extends Exception implements CommonErro {

    private CommonErro commonErro;

    public BusinessException(CommonErro commonErro) {
        super();
        this.commonErro = commonErro;
    }

    public BusinessException(String message, CommonErro commonErro) {
        super();
        this.commonErro = commonErro;
        this.commonErro.setErroMsg(message);
    }



    @Override
    public int getErroCode() {
        return 0;
    }

    @Override
    public String getErroMsg() {
        return null;
    }

    @Override
    public CommonErro setErroMsg(String erroMsg) {
        return null;
    }
}
