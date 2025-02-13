package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.inventories.orders.application.ports.in.DeleteOneOrderByIdUseCase;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
public class DeleteOneOrderByIdRestController {
    private final DeleteOneOrderByIdUseCase deleteOneOrderByIdUseCase;
    public DeleteOneOrderByIdRestController(DeleteOneOrderByIdUseCase deleteOneOrderByIdUseCase) {
        this.deleteOneOrderByIdUseCase = deleteOneOrderByIdUseCase;
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteOneOrderById(@PathVariable Integer id) {
        return this.deleteOneOrderByIdUseCase.execute(id);
    }
}
