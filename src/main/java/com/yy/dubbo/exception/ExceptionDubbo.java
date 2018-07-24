package com.yy.dubbo.exception;

/**
 * @Author: yhy
 * @Date: 2018/7/24 15:40
 * @Version 1.0
 */
public class ExceptionDubbo extends Exception{
    private String errorCode;
    private String errorMessage;

    public ExceptionDubbo(String errrorCode) {
        this.errorCode = errrorCode;
    }

    public ExceptionDubbo(String errrorCode,String errorMessage) {
        super(errorMessage);
        this.errorCode = errrorCode;
    }
    public ExceptionDubbo(String errrorCode,Throwable cause) {
        this(errrorCode,errrorCode,cause);
    }

    public ExceptionDubbo(String errrorCode,String errorMessage,Throwable cause) {
        super(errorMessage,cause);
        this.errorCode = errrorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        String message = super.getMessage();
        return message;
    }
}
