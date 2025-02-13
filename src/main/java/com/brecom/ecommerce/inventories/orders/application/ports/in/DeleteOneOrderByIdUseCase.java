package com.brecom.ecommerce.inventories.orders.application.ports.in;

import reactor.core.publisher.Mono;

public interface DeleteOneOrderByIdUseCase {
    Mono<Void> execute(Integer id);
}
