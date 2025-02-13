package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.validations.ObjectValidator;
import com.brecom.ecommerce.inventories.orders.application.ports.in.UpdateOneOrderByIdUseCase;
import com.brecom.ecommerce.inventories.orders.domain.models.Order;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderUpdateRequest;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
public class UpdateOneOrderByIdRestController {
    private final UpdateOneOrderByIdUseCase updateOneOrderByIdUseCase;
    private final ObjectValidator objectValidator;
    public UpdateOneOrderByIdRestController(
            UpdateOneOrderByIdUseCase updateOneOrderByIdUseCase,
            ObjectValidator objectValidator
    ) {
        this.updateOneOrderByIdUseCase = updateOneOrderByIdUseCase;
        this.objectValidator = objectValidator;
    }
    @PatchMapping("/{id}")
    public Mono<Void> updateOneOrderById(
            @PathVariable Integer id,
            @RequestBody OrderUpdateRequest orderUpdateRequest
    ) {
        this.objectValidator.validate(orderUpdateRequest);
        Order order = OrderRestMapper.updateRequestToDomain(orderUpdateRequest);
        return this.updateOneOrderByIdUseCase.execute(id, order);
    }
}
