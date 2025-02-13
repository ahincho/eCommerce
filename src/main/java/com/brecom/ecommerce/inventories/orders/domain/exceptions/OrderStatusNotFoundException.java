package com.brecom.ecommerce.inventories.orders.domain.exceptions;

public class OrderStatusNotFoundException extends RuntimeException {
    public OrderStatusNotFoundException(String message) {
        super(message);
    }
}
