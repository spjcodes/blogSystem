package com.jiayeli.blog.common.utils.logger;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;

/**
 * @author: jiayeli.cn
 * @description logger utils
 * @date: 2022/9/11 下午9:40
 */

public class LoggerUtils {

    /**
     * @param e
     * @return
     */
    public static String errorInfoExtract(Exception e) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------------------------------------------------------------")
                .append(e.getMessage())
                .append("cause by:\t")
                .append(e.getCause() != null ? e.getCause().getMessage() : "unknown");
        Arrays.stream(e.getStackTrace()).forEach(errorInfo -> {
            stringBuffer
                    .append("\n[ModuleName]: ").append(errorInfo.getModuleName())
                    .append("\t[ModuleVersion]: ").append(errorInfo.getModuleVersion())

                    .append("\t[FileName]: ").append(errorInfo.getFileName())
                    .append("\t[ClassName]: ").append(errorInfo.getClassName())
                    .append("\t[LineNumber]: ").append(errorInfo.getLineNumber())
                    .append("\t[MethodName]: ").append(errorInfo.getMethodName());
        });
        stringBuffer.append("\n----------------------------------------------------------");
        String errorDetail = stringBuffer.toString();
        stringBuffer.setLength(0);
        return errorDetail;
    }

    public static String undeclaredThrowableExceptionInfoExtract(UndeclaredThrowableException e) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append("\n------------------------------------------------------------")
                .append(e.getMessage())
                .append("cause by:\t")
                .append(e.getCause() != null ? e.getCause().getMessage() : "unknown");
        Arrays.stream(e.getUndeclaredThrowable().getStackTrace()).forEach(errorInfo -> {
            stringBuffer
//                    .append("\n[ModuleName]: ").append(errorInfo.getMethodName())
//                    .append("\t[ModuleVersion]: ").append(errorInfo.getLineNumber())
                    .append("\t[FileName]: ").append(errorInfo.getFileName())
                    .append("\t[ClassName]: ").append(errorInfo.getClassName())
                    .append("\t[LineNumber]: ").append(errorInfo.getLineNumber())
                    .append("\t[MethodName]: ").append(errorInfo.getMethodName());
        });
        stringBuffer.append("\n----------------------------------------------------------");
        String errorDetail = stringBuffer.toString();
        stringBuffer.setLength(0);
        return errorDetail;
    }
}
