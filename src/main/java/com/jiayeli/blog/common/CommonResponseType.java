package com.jiayeli.blog.common;



import com.jiayeli.blog.common.response.CommonResponse;
import com.jiayeli.blog.common.response.ResponseEnums;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Data
public class CommonResponseType implements CommonResponse {

    private int statusCode;

    private String desc;

    private Object result;

    public CommonResponseType() {
    }


    public static CommonResponseType ok(Object result) {
        return create(200, result);
    }

    public static CommonResponseType create(int statusCode, Object result) {
        CommonResponseType commonResponseType = new CommonResponseType();
        commonResponseType.setStatus(statusCode);
        commonResponseType.setResult(result);
       return commonResponseType;
    }

    public static CommonResponseType create(int statusCode, String desc, Object result) {
        CommonResponseType commonResponseType = new CommonResponseType();
        commonResponseType.setStatus(statusCode);
        commonResponseType.setDesc(desc);
        commonResponseType.setResult(result);
        return commonResponseType;
    }

    public static CommonResponseType error(ResponseEnums error) {
        return create(error.getStatusCode(), error.getDesc(), null);
    }

    public static CommonResponseType error(ResponseEnums error, String errorMsg) {
        return create(error.getStatusCode(), errorMsg, null);
    }

    public void setStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setResult (Object result) {
        this.result = result;
    }

    public int getStatus() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonResponseType that = (CommonResponseType) o;
        return statusCode == that.statusCode && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, result);
    }

    @Override
    public String toString() {
        return "CommonResponseType{" +
                "statusCode=" + statusCode +
                ", desc='" + desc + '\'' +
                ", result=" + result +
                '}';
    }
}
