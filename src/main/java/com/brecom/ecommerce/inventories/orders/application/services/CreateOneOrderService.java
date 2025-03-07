package com.brecom.ecommerce.inventories.orders.application.services;

import com.brecom.ecommerce.inventories.orders.application.ports.in.CreateOneOrderUseCase;
import com.brecom.ecommerce.inventories.orders.application.ports.out.OrderPersistencePort;
import com.brecom.ecommerce.inventories.orders.domain.models.Order;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class CreateOneOrderService implements CreateOneOrderUseCase {
    private final OrderPersistencePort orderPersistencePort;
    public CreateOneOrderService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Mono<Order> execute(Order order) {
        return this.orderPersistencePort.createOneOrder(order);
    }
}
