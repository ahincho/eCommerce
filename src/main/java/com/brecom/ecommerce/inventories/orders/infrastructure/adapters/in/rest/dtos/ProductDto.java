package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO representing a product in the order.")
public class ProductDto {
    @Schema(
            description = "Name of the product. Must be between 1 and 64 characters.",
            example = "Laptop"
    )
    @NotBlank(message = "Each product must not be blank")
    @Size(min = 1, max = 64, message = "Each product name must have a length between 1 and 64 characters")
    private String name;
}
