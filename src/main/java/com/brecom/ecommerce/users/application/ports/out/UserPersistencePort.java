package com.brecom.ecommerce.users.application.ports.out;

import com.brecom.ecommerce.users.domain.models.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserPersistencePort {
    Mono<User> createOneUser(User user);
    Flux<User> findUsers();
    Mono<User> findOneUserById(Integer id);
    Mono<Boolean> existsOneUserById(Integer id);
    Mono<Boolean> existsOneUserByEmail(String email);
    Mono<Void> updateOneUserById(Integer id, User user);
    Mono<Void> deleteOneUserById(Integer id);
}
