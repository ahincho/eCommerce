package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

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
@Schema(description = "Response object for returning order details.")
public class OrderResponse {
    @Schema(
            description = "Unique identifier for the order.",
            example = "12345"
    )
    private Integer id;
    @Schema(
            description = "Name of the supplier for the order.",
            example = "Tech Supplies"
    )
    private String supplier;
    @Schema(
            description = "List of product names in the order.",
            example = "[\"Laptop\", \"Wireless Mouse\", \"Keyboard\"]"
    )
    private List<String> products;
    @Schema(
            description = "Current status of the order.",
            example = "COMPLETED"
    )
    private String status;
    @Schema(
            description = "Timestamp when the order was created.",
            example = "2025-02-12T10:15:30"
    )
    private LocalDateTime createdAt;
    @Schema(
            description = "Timestamp when the order was last updated.",
            example = "2025-02-12T11:00:00"
    )
    private LocalDateTime updatedAt;
}
