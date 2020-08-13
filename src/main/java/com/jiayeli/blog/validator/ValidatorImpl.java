package com.jiayeli.blog.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

    public ValidationResult validator(Object bean) {
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size()>0) {
            constraintViolationSet.forEach(constraintViolation -> {
                result.setHasErros(true);
                String erroMsg = constraintViolation.getMessage();
                String patamName = constraintViolation.getPropertyPath().toString();
                result.getErrMsgMap().put(patamName, erroMsg);
            });
        }

        return result;
    }

    /**
     * bean 后置处理器 将this.validator通过hibernate validator工厂的初始化方式实例化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}
