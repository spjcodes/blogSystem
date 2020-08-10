package com.jiayeli.blog.validator;

import lombok.Getter;
import lombok.Setter;

public class CommonReturnType {

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private Object object;


    public static CommonReturnType  create(Object object) {
        return CommonReturnType.create("successful", object);
    }

    public static CommonReturnType create (String status, Object object) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setStatus(status);
        commonReturnType.setObject(object);
        return commonReturnType;
    }




}
