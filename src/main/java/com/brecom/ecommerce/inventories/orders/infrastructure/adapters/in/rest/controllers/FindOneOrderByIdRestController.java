package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.inventories.orders.application.ports.in.FindOneOrderByIdUseCase;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderResponse;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
    @Operation(
            summary = "Retrieve an order by its ID",
            description = "Fetches the details of an order based on the provided order ID.",
            tags = {"Orders"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Order found successfully.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Order not found. The order with the specified ID does not exist."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid order ID format. The provided ID is not a valid integer."
    )
    @GetMapping("/{orderId}")
    public Mono<OrderResponse> findOneOrderById(@PathVariable Integer orderId) {
        return this.findOneOrderByIdUseCase
                .execute(orderId)
                .map(OrderRestMapper::domainToResponse);
    }
}
