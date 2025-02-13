package com.brecom.ecommerce.commons.domain.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ValidationException extends RuntimeException {
    private final List<String> messages;
    public ValidationException(String message, List<String> messages) {
        super(message);
        this.messages = messages;
    }
}
