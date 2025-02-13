package com.brecom.ecommerce.inventories.orders.application.services;

import com.brecom.ecommerce.inventories.orders.application.ports.in.FindOneOrderByIdUseCase;
import com.brecom.ecommerce.inventories.orders.application.ports.out.OrderPersistencePort;
import com.brecom.ecommerce.inventories.orders.domain.models.Order;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class FindOneOrderByIdService implements FindOneOrderByIdUseCase {
    private final OrderPersistencePort orderPersistencePort;
    public FindOneOrderByIdService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Mono<Order> execute(Integer id) {
        return this.orderPersistencePort.findOneOrderById(id);
    }
}
