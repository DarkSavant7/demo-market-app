package org.example.demomarketapp.web;

import lombok.extern.slf4j.Slf4j;
import org.example.demomarketapp.dto.ErrorDto;
import org.example.demomarketapp.error.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MarketExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> productNotFoundException(ProductNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto(
                "Product Not Found",
                exception.getMessage()
        );
        log.error("Product not found", exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDto> exceptionHandle(Exception exception) {
        log.error("Something went wrong", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto("Something Wrong", exception.getMessage()));
    }
}
