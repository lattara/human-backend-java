package com.human.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice (annotations = RestController.class)

public class ExceptionAdvd extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<CustomError> handleUserNotFoundException(NotFoundException ex, WebRequest request)
    {
        CustomError error = new CustomError(HttpStatus.NOT_FOUND.toString(), "User not found", "field");
        //error.setStackTrace(new StackTraceElement[0]); // we don't want whole stack trace
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }


}
