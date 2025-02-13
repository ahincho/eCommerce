package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.out.persistence.r2bdc;

import com.brecom.ecommerce.inventories.orders.application.ports.out.OrderPersistencePort;
import com.brecom.ecommerce.inventories.orders.domain.models.Order;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class OrderR2dbcPersistenceAdapter implements OrderPersistencePort {
    private final OrderR2dbcRepository orderR2dbcRepository;
    public OrderR2dbcPersistenceAdapter(OrderR2dbcRepository orderR2dbcRepository) {
        this.orderR2dbcRepository = orderR2dbcRepository;
    }
    @Override
    @Transactional
    public Mono<Order> createOneOrder(Order order) {
        return this.orderR2dbcRepository
                .save(OrderR2dbcMapper.domainToEntity(order))
                .map(OrderR2dbcMapper::entityToDomain);
    }
    @Override
    public Flux<Order> findOrders() {
        return this.orderR2dbcRepository
                .findAll()
                .map(OrderR2dbcMapper::entityToDomain);
    }
    @Override
    public Mono<Order> findOneOrderById(Integer id) {
        return this.orderR2dbcRepository
                .findById(id)
                .map(OrderR2dbcMapper::entityToDomain);
    }
    @Override
    @Transactional
    public Mono<Void> updateOneOrderById(Integer id, Order order) {
        OrderEntity orderEntity = OrderR2dbcMapper.domainToEntity(order);
        orderEntity.setId(id);
        return this.orderR2dbcRepository.save(orderEntity).then();
    }
    @Override
    @Transactional
    public Mono<Void> deleteOneOrderById(Integer id) {
        return this.orderR2dbcRepository.deleteById(id);
    }
}
