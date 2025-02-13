package com.brecom.ecommerce.inventories.orders.application.services;

import com.brecom.ecommerce.inventories.orders.application.ports.in.DeleteOneOrderByIdUseCase;
import com.brecom.ecommerce.inventories.orders.application.ports.out.OrderPersistencePort;
import com.brecom.ecommerce.inventories.orders.domain.exceptions.OrderNotFoundException;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class DeleteOneOrderByIdService implements DeleteOneOrderByIdUseCase {
    private final OrderPersistencePort orderPersistencePort;
    public DeleteOneOrderByIdService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Mono<Void> execute(Integer id) {
        return this.orderPersistencePort.existsOneOrderById(id)
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new OrderNotFoundException("Order with id '" + id + "' not found"));
                    }
                    return this.orderPersistencePort.deleteOneOrderById(id);
                });
    }
}
