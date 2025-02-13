package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.validations.ObjectValidator;
import com.brecom.ecommerce.inventories.orders.application.ports.in.CreateOneOrderUseCase;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderCreateRequest;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderResponse;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
public class CreateOneOrderRestController {
    private final CreateOneOrderUseCase createOneOrderUseCase;
    private final ObjectValidator objectValidator;
    public CreateOneOrderRestController(
            CreateOneOrderUseCase createOneOrderUseCase,
            ObjectValidator objectValidator
    ) {
        this.createOneOrderUseCase = createOneOrderUseCase;
        this.objectValidator = objectValidator;
    }
    @PostMapping
    public Mono<OrderResponse> createOneOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        this.objectValidator.validate(orderCreateRequest);
        return this.createOneOrderUseCase
                .execute(OrderRestMapper.createRequestToDomain(orderCreateRequest))
                .map(OrderRestMapper::domainToResponse);
    }
}
