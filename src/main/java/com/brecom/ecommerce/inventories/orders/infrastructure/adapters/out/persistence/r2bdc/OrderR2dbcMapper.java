package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.out.persistence.r2bdc;

import com.brecom.ecommerce.inventories.orders.domain.models.Order;

import java.time.LocalDateTime;

public class OrderR2dbcMapper {
    private OrderR2dbcMapper() {}
    public static OrderEntity domainToEntity(Order order) {
        return OrderEntity.builder()
                .supplier(order.getSupplier())
                .products(order.getProducts())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt() == null ? LocalDateTime.now() : order.getCreatedAt())
                .updatedAt(order.getUpdatedAt() == null ? LocalDateTime.now() : order.getUpdatedAt())
                .build();
    }
    public static Order entityToDomain(OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .supplier(orderEntity.getSupplier())
                .products(orderEntity.getProducts())
                .status(orderEntity.getStatus())
                .createdAt(orderEntity.getCreatedAt())
                .updatedAt(orderEntity.getUpdatedAt())
                .build();
    }
}
