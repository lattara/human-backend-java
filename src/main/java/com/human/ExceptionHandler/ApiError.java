package com.human.ExceptionHandler;

public class ApiError extends RuntimeException{
    private int status;
    private String message;

    public ApiError() {
    }

    public ApiError(String error, String message) {
    }

    public ApiError(String s) {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
