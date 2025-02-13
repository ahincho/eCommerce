package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.inventories.orders.application.ports.in.FindOneOrderByIdUseCase;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderResponse;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
public class FindOneOrderByIdRestController {
    private final FindOneOrderByIdUseCase findOneOrderByIdUseCase;
    public FindOneOrderByIdRestController(FindOneOrderByIdUseCase findOneOrderByIdUseCase) {
        this.findOneOrderByIdUseCase = findOneOrderByIdUseCase;
    }
    @GetMapping("/{id}")
    public Mono<OrderResponse> findOneOrderById(@PathVariable Integer id) {
        return this.findOneOrderByIdUseCase
                .execute(id)
                .map(OrderRestMapper::domainToResponse);
    }
}
