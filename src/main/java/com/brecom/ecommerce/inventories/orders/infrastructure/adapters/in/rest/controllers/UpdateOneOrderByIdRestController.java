package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.validations.ObjectValidator;
import com.brecom.ecommerce.inventories.orders.application.ports.in.UpdateOneOrderByIdUseCase;
import com.brecom.ecommerce.inventories.orders.domain.models.Order;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderUpdateRequest;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Operation(
            summary = "Update an existing order",
            description = "Updates the details of an existing order identified by its ID. The order's details, such as supplier, products, and status, will be modified.",
            tags = {"Orders"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Order updated successfully.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid request. The provided data did not pass validation."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Order not found. No order exists with the provided ID."
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error. An unexpected error occurred while updating the order."
    )
    @PatchMapping("/{orderId}")
    public Mono<Void> updateOneOrderById(
            @PathVariable Integer orderId,
            @RequestBody OrderUpdateRequest orderUpdateRequest
    ) {
        this.objectValidator.validate(orderUpdateRequest);
        Order order = OrderRestMapper.updateRequestToDomain(orderUpdateRequest);
        return this.updateOneOrderByIdUseCase.execute(orderId, order);
    }
}
