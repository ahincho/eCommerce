package com.brecom.ecommerce.inventories.orders.domain.models;

import com.brecom.ecommerce.inventories.orders.domain.exceptions.OrderStatusNotFoundException;

public enum OrderStatus {
    PENDING,
    CONFIRMED,
    SHIPPED,
    PROGRESS,
    DELIVERED,
    CANCELLED,
    COMPLETED;
    public static OrderStatus fromString(String status) {
        try {
            return valueOf(status.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException exception) {
            throw new OrderStatusNotFoundException("Invalid order status: " + status);
        }
    }
}
