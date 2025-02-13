package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.in.rest.annotations;

import com.brecom.ecommerce.inventories.orders.domain.exceptions.OrderStatusNotFoundException;
import com.brecom.ecommerce.inventories.orders.domain.models.OrderStatus;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OrderStatusValidator implements ConstraintValidator<ValidOrderStatus, String> {
    private static final String validValues = Arrays.stream(OrderStatus.values())
            .map(Enum::name)
            .collect(Collectors.joining(", "));
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        try {
            OrderStatus.fromString(value);
            return true;
        } catch (OrderStatusNotFoundException exception) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid order status. Must be one of the following: " + validValues).addConstraintViolation();
            return false;
        }
    }
}
