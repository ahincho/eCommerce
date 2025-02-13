package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.inventories.orders.application.ports.in.FindOrdersUseCase;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderResponse;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
    @Operation(
            summary = "Retrieve all orders",
            description = "Fetches a list of all orders from the system.",
            tags = {"Orders"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "List of orders retrieved successfully.",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrderResponse.class)))
    )
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error. An unexpected error occurred while fetching the orders."
    )
    @GetMapping
    public Flux<OrderResponse> findOrders() {
        return this.findOrdersUseCase
                .execute()
                .map(OrderRestMapper::domainToResponse);
    }
}
