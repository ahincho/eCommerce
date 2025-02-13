package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.mappers;

import com.brecom.ecommerce.inventories.orders.domain.models.Order;
import com.brecom.ecommerce.inventories.orders.domain.models.OrderStatus;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderCreateRequest;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderResponse;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.OrderUpdateRequest;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.dtos.ProductDto;

public class OrderRestMapper {
    private OrderRestMapper() {}
    public static OrderResponse domainToResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .supplier(order.getSupplier())
                .products(order.getProducts())
                .status(order.getStatus().toString())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }
    public static Order createRequestToDomain(OrderCreateRequest orderCreateRequest) {
        return Order.builder()
                .supplier(orderCreateRequest.getSupplier())
                .products(orderCreateRequest.getProducts().stream().map(ProductDto::getName).toList())
                .status(OrderStatus.PENDING)
                .build();
    }
    public static Order updateRequestToDomain(OrderUpdateRequest orderUpdateRequest) {
        return Order.builder()
                .supplier(orderUpdateRequest.getSupplier())
                .products(orderUpdateRequest.getProducts().stream().map(ProductDto::getName).toList())
                .status(OrderStatus.fromString(orderUpdateRequest.getStatus()))
                .build();
    }
}
