package com.github.jrlcst.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorMessage> handleCustomNotFoundException(CustomException e){
        var response = new ErrorMessage();
        if (e.getMessage().contains("not exists")) {
            response.setMessage(e.getMessage());
            response.setTimestamp(LocalDateTime.now());
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}