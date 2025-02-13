package com.brecom.ecommerce.inventories.orders.application.services;

import com.brecom.ecommerce.inventories.orders.application.ports.in.UpdateOneOrderByIdUseCase;
import com.brecom.ecommerce.inventories.orders.application.ports.out.OrderPersistencePort;
import com.brecom.ecommerce.inventories.orders.domain.exceptions.OrderNotFoundException;
import com.brecom.ecommerce.inventories.orders.domain.models.Order;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class UpdateOneOrderByIdService implements UpdateOneOrderByIdUseCase {
    private final OrderPersistencePort orderPersistencePort;
    public UpdateOneOrderByIdService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }
    @Override
    public Mono<Void> execute(Integer id, Order order) {
        return this.orderPersistencePort.existsOneOrderById(id)
                .flatMap(exists -> {
                   if (Boolean.FALSE.equals(exists)) {
                       return Mono.error(new OrderNotFoundException("Order with id '" + id + "' not found"));
                   }
                   return this.orderPersistencePort.findOneOrderById(id);
                })
                .flatMap(existingOrder -> {
                    existingOrder.setSupplier(order.getSupplier());
                    existingOrder.setProducts(order.getProducts());
                    existingOrder.setStatus(order.getStatus());
                    existingOrder.setUpdatedAt(LocalDateTime.now());
                    return this.orderPersistencePort.updateOneOrderById(id, existingOrder);
                });
    }
}
