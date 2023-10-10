package com.wanted.api.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ErrorException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(ErrorException e) {
        ErrorResponse response = new ErrorResponse(e.getErrorCode().name(),e.getMessage());
        log.error("ErrorException {}",e.getMessage());
        return new ResponseEntity<>(response,e.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleNonExistentDataException(EmptyResultDataAccessException e) {
        ErrorResponse response = new ErrorResponse(ErrorCode.NON_EXISTENT_DATA.name(), e.getMessage());
        log.error("EmptyResultDataAccessException {}",e.getMessage());
        return new ResponseEntity<>(response, ErrorCode.NON_EXISTENT_DATA.getHttpStatus());
    }

    @ExceptionHandler(value = HttpMessageConversionException.class)
    public ResponseEntity<Object> handleNonExistentDataException(HttpMessageConversionException e) {
        ErrorResponse response = new ErrorResponse(ErrorCode.INVALID_VARIABLE.name(), e.getMessage());
        log.error("HttpMessageConversionException {}",e.getMessage());
        return new ResponseEntity<>(response, ErrorCode.INVALID_VARIABLE.getHttpStatus());
    }
}
