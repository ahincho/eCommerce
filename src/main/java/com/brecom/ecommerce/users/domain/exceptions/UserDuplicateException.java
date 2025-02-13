package com.brecom.ecommerce.users.domain.exceptions;

public class UserDuplicateException extends RuntimeException {
    public UserDuplicateException(String message) {
        super(message);
    }
}
