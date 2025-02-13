package com.brecom.ecommerce.commons.infrastructure.configurations;

import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.out.persistence.r2bdc.OrderStatusReadConverter;
import com.brecom.ecommerce.inventories.orders.infrastructure.adapters.out.persistence.r2bdc.OrderStatusWriteConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;

import java.util.List;

@Configuration
public class R2dbcConfiguration {
    @Bean
    public OrderStatusReadConverter orderStatusReadConverter() {
        return new OrderStatusReadConverter();
    }
    @Bean
    public OrderStatusWriteConverter orderStatusWriteConverter() {
        return new OrderStatusWriteConverter();
    }
    @Bean
    public R2dbcCustomConversions r2dbcCustomConversions(
            OrderStatusReadConverter orderStatusReadConverter,
            OrderStatusWriteConverter orderStatusWriteConverter
    ) {
        List<Converter<?, ?>> converters = List.of(orderStatusReadConverter, orderStatusWriteConverter);
        return new R2dbcCustomConversions(CustomConversions.StoreConversions.NONE, converters);
    }
}
