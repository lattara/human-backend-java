package com.human.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ResourceNotFound extends ApiError {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);


}
