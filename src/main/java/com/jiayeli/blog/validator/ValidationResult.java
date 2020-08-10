package com.jiayeli.blog.validator;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ValidationResult {

    @Getter
    @Setter
    private boolean hasErros = false;

    @Setter
    @Getter
    private Map<String, String> errMsgMap = new HashMap<>();

    public String getErroMag() {
        return StringUtils.join(errMsgMap,",");
    }
}
