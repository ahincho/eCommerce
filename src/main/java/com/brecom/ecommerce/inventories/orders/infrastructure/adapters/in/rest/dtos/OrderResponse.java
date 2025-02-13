package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Integer id;
    private String supplier;
    private List<String> products;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
