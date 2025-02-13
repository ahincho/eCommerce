package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.inventories.orders.application.ports.in.DeleteOneOrderByIdUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
    @Operation(
            summary = "Delete an order by its ID",
            description = "Deletes an existing order from the system by its unique identifier.",
            tags = {"Orders"}
    )
    @ApiResponse(
            responseCode = "204",
            description = "Order deleted successfully.",
            content = @Content(mediaType = "application/json")
    )
    @ApiResponse(
            responseCode = "404",
            description = "Order not found. The order with the specified ID does not exist."
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid order ID format. The provided ID is not a valid integer."
    )
    @DeleteMapping("/{orderId}")
    public Mono<Void> deleteOneOrderById(@PathVariable Integer orderId) {
        return this.deleteOneOrderByIdUseCase.execute(orderId);
    }
}
