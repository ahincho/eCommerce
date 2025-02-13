package com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.advices;

import com.brecom.ecommerce.commons.domain.exceptions.ValidationException;
import com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.dtos.ValidationExceptionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(ValidationException.class)
    public Mono<ResponseEntity<ValidationExceptionResponse>> handleValidationException(
            ValidationException validationException,
            ServerWebExchange serverWebExchange
    ) {
        ValidationExceptionResponse validationExceptionResponse = ValidationExceptionResponse.builder()
                .path(serverWebExchange.getRequest().getPath().toString())
                .method(serverWebExchange.getRequest().getMethod().name())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .statusDescription(HttpStatus.BAD_REQUEST.name())
                .messages(validationException.getMessages())
                .build();
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationExceptionResponse));
    }
}
