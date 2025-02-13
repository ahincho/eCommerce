package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos;

import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.annotations.ValidOrderStatus;

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
public class OrderUpdateRequest {
    @NotBlank
    @Size(min = 1, max = 64)
    private String supplier;
    @Size(min = 1) @Valid
    private List<@NotBlank @Size(min = 1, max = 64) String> products;
    @NotBlank
    @ValidOrderStatus
    private String status;
}
