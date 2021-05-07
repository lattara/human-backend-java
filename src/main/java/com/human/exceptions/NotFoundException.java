package com.human.exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    private String field;

    public NotFoundException(){
    }

    public NotFoundException(String message, String field) {
        this.message = message;
        this.field = field;
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
}
