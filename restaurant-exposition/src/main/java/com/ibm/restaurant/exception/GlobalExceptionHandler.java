package com.ibm.restaurant.exception;

import com.ibm.restaurant.domain.exception.BusinessException;
import com.ibm.restaurant.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionDTO> handleBusinessException(BusinessException exception) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.message = exception.getMessage();
        dto.code = exception.getCode();
        dto.status = HttpStatus.BAD_REQUEST.value();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundException(NotFoundException ex){
        ExceptionDTO dto = new ExceptionDTO();
        dto.message = ex.getMessage();
        dto.code = "NOT_FOUND";
        dto.status = HttpStatus.NOT_FOUND.value();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

}