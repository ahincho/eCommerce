package com.brecom.ecommerce.inventories.orders.infrastructure.adapters.out.persistence.r2bdc;

import com.brecom.ecommerce.inventories.orders.domain.models.OrderStatus;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class OrderStatusReadConverter implements Converter<String, OrderStatus> {
    @Override
    public OrderStatus convert(String status) {
        return OrderStatus.fromString(status);
    }
}
