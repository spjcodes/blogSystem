package com.jiayeli.blog.common.response;


import com.jiayeli.blog.common.error.CommonError;

public enum StreamProcessModuleErrorEnum implements CommonResponse, CommonError {

    GENERATOR_JOB_GRAPH_ERROR(100001, "generator jobGraph error"),
    PARAMETER_ERROR(100002, "parameter error"),
    VARIATE_IS_NULL(100003, "variate is null"),
    YARN_RUNTIME_EXCEPTION(100004, "yarn runtime exception"),
    EXECUTOR_JOB_ERROR(100005, "executor preJob error"),
    DEPLOYMENT_TARGET_ERROR(100003, "unsupported job deployment target"),
    FILE_NOT_FOUND(200001, "file not found"),
            ;

    private int code;

    private String desc;

    StreamProcessModuleErrorEnum(int code, String msg) {
        this.code = code;
        this.desc = msg;
    }

    @Override
    public int getErrCode() {
        return this.code;
    }

    @Override
    public String getErrMsg() {
        return this.desc;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        setErrMsg(errMsg);
        return this;
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
}
