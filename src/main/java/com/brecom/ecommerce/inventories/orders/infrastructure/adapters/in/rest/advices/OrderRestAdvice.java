package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.advices;

import com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.dtos.ExceptionResponse;
import com.brecom.ecommerce.inventories.orders.domain.exceptions.OrderNotFoundException;

import com.brecom.ecommerce.inventories.orders.domain.exceptions.OrderStatusNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class OrderRestAdvice {
    @ExceptionHandler(OrderNotFoundException.class)
    public Mono<ResponseEntity<ExceptionResponse>> orderNotFound(
            OrderNotFoundException orderNotFoundException,
            ServerWebExchange serverWebExchange
    ) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .path(serverWebExchange.getRequest().getPath().toString())
                .method(serverWebExchange.getRequest().getMethod().name())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusDescription(HttpStatus.NOT_FOUND.name())
                .message(orderNotFoundException.getMessage())
                .build();
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse));
    }
    @ExceptionHandler(OrderStatusNotFoundException.class)
    public Mono<ResponseEntity<ExceptionResponse>> orderStatusNotFound(
            OrderStatusNotFoundException orderStatusNotFoundException,
            ServerWebExchange serverWebExchange
    ) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .path(serverWebExchange.getRequest().getPath().toString())
                .method(serverWebExchange.getRequest().getMethod().name())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .statusDescription(HttpStatus.NOT_FOUND.name())
                .message(orderStatusNotFoundException.getMessage())
                .build();
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse));
    }
}
