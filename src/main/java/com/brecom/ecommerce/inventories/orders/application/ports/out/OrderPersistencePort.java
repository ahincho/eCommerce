package com.brecom.ecommerce.inventories.orders.application.ports.out;

import com.brecom.ecommerce.inventories.orders.domain.models.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderPersistencePort {
    Mono<Order> createOneOrder(Order order);
    Flux<Order> findOrders();
    Mono<Order> findOneOrderById(Integer id);
    Mono<Void> updateOneOrderById(Integer id, Order order);
    Mono<Void> deleteOneOrderById(Integer id);
}
