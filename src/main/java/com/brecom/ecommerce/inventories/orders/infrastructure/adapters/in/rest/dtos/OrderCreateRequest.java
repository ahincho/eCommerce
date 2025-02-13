package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos;

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
public class OrderCreateRequest {
    @NotBlank
    @Size(min = 1, max = 64)
    private String supplier;
    @Size(min = 1) @Valid
    private List<@NotBlank @Size(min = 1, max = 64) String> products;
}
