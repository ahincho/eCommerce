package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos;

import com.brecom.ecommerce.inventories.orders.domain.models.OrderStatus;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.annotations.ValidOrderStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateRequest {
    @NotBlank(message = "The 'supplier' field cannot be blank")
    @Size(min = 1, max = 64, message = "The 'supplier' field must have a length between 1 and 64 characters")
    private String supplier;
    @Valid
    @Size(min = 1, message = "The 'products' list must contain at least one product")
    private List<ProductDto> products;
    @ValidOrderStatus
    private String status;
}
