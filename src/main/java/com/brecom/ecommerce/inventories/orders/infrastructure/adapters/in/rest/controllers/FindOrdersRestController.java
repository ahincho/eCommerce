package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.inventories.orders.application.ports.in.FindOrdersUseCase;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderResponse;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/orders")
public class FindOrdersRestController {
    private final FindOrdersUseCase findOrdersUseCase;
    public FindOrdersRestController(FindOrdersUseCase findOrdersUseCase) {
        this.findOrdersUseCase = findOrdersUseCase;
    }
    @GetMapping
    public Flux<OrderResponse> findOrders() {
        return this.findOrdersUseCase
                .execute()
                .map(OrderRestMapper::domainToResponse);
    }
}
