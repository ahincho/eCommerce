package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.controllers;

import com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.dtos.ExceptionResponse;
import com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.validations.ObjectValidator;
import com.brecom.ecommerce.inventories.orders.application.ports.in.CreateOneOrderUseCase;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderCreateRequest;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderResponse;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers.OrderRestMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
    @Operation(
            summary = "Create a new order",
            description = "Creates a new order based on the provided details such as products, supplier, and other order-specific information.",
            tags = {"Orders"}
    )
    @ApiResponse(
            responseCode = "201",
            description = "Order created successfully.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid input data. The request body did not pass validation.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
    )
    @ApiResponse(
            responseCode = "500",
            description = "Unexpected server error.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
    )
    @PostMapping
    public Mono<OrderResponse> createOneOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        this.objectValidator.validate(orderCreateRequest);
        return this.createOneOrderUseCase
                .execute(OrderRestMapper.createRequestToDomain(orderCreateRequest))
                .map(OrderRestMapper::domainToResponse);
    }
}
