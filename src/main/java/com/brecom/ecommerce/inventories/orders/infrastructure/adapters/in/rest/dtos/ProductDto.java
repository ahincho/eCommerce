package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos;

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
public class ProductDto {
    @NotBlank(message = "Each product must not be blank")
    @Size(min = 1, max = 64, message = "Each product name must have a length between 1 and 64 characters")
    private String name;
}
