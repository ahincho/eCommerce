package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.annotations;

import com.brecom.ecommerce.inventories.orders.domain.exceptions.OrderStatusNotFoundException;
import com.brecom.ecommerce.inventories.orders.domain.models.OrderStatus;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrderStatusValidator implements ConstraintValidator<ValidOrderStatus, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        try {
            OrderStatus.fromString(value);
            return true;
        } catch (OrderStatusNotFoundException exception) {
            return false;
        }
    }
}
