package com.brecom.ecommerce.users.application.ports.in;

import com.brecom.ecommerce.users.domain.models.User;

import reactor.core.publisher.Mono;

public interface CreateOneUserUseCase {
    Mono<User> execute(User user);
}
