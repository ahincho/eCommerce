package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for creating a new order.")
public class OrderCreateRequest {
    @Schema(
            description = "Name of the supplier for the order. Must be between 1 and 64 characters.",
            example = "Tech Supplies"
    )
    @NotBlank(message = "The 'supplier' field cannot be blank")
    @Size(min = 1, max = 64, message = "The 'supplier' field must have a length between 1 and 64 characters")
    private String supplier;
    @Schema(
            description = "List of products included in the order. Must contain at least one product.",
            example = "[{\"name\": \"Laptop\"}, {\"name\": \"Wireless Mouse\"}]"
    )
    @Valid
    @Size(min = 1, message = "The 'products' list must contain at least one product")
    private List<ProductDto> products;
}
