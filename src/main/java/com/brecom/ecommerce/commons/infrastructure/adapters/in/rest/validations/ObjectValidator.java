package com.brecom.ecommerce.commons.infrastructure.adapters.in.rest.validations;

import com.brecom.ecommerce.commons.domain.exceptions.ValidationException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ObjectValidator {
    private final Validator validator;
    public ObjectValidator(Validator validator) {
        this.validator = validator;
    }
    public <T> void validate(T object) {
        Set<ConstraintViolation<T>> errors = this.validator.validate(object);
        if (!errors.isEmpty()) {
            List<String> messages = errors.stream().map(ConstraintViolation::getMessage).toList();
            throw new ValidationException("Something went wrong while validating object", messages);
        }
    }
}
