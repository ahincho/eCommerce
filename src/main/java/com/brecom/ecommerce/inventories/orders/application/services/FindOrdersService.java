package com.brecom.ecommerce.inventories.orders.application.services;

import com.brecom.ecommerce.inventories.orders.application.ports.in.FindOrdersUseCase;
import com.brecom.ecommerce.inventories.orders.application.ports.out.OrderPersistencePort;
import com.brecom.ecommerce.inventories.orders.domain.models.Order;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class FindOrdersService implements FindOrdersUseCase {
    private final OrderPersistencePort orderPersistencePort;
    public FindOrdersService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Flux<Order> execute() {
        return this.orderPersistencePort.findOrders();
    }
}
