package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.out.persistence.r2bdc;

import com.brecom.ecommerce.inventories.orders.domain.models.OrderStatus;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class OrderStatusWriteConverter implements Converter<OrderStatus, String> {
    @Override
    public String convert(OrderStatus status) {
        return status.name();
    }
}
