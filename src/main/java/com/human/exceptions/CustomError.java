package com.human.exceptions;

import java.util.List;

public class CustomError extends NotFoundException {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private String field;

    public CustomError() {

    }

    public CustomError(String code, String message, String field) {
        super();
        this.code = code;
        this.message = message;
        this.field = field;
    }

    public CustomError(String incorrect_request, List<String> details) {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
