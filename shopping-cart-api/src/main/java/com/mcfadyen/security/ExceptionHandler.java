package com.mcfadyen.security;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
    protected ResponseEntity<Object> handleInvalidRequest(Exception e, WebRequest request) {
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, String.format("{\"error\":\"%s\"}", e.getMessage()), headers, HttpStatus.UNAUTHORIZED, request);
    }
   
}