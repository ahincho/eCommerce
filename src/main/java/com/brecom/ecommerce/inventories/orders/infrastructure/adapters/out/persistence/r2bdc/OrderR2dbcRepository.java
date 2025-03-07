package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.out.persistence.r2bdc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderR2dbcRepository extends ReactiveCrudRepository<OrderEntity, Integer> {

}
