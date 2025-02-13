package com.brecom.ecommerce.inventories.orders.application.ports.in;

import com.brecom.ecommerce.inventories.orders.domain.models.Order;

import reactor.core.publisher.Mono;

public interface CreateOneOrderUseCase {
    Mono<Order> execute(Order order);
}
