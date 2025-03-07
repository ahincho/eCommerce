package com.brecom.ecommerce.inventories.orders.domain.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderConfirmedEvent {
    // Domain Event to Decrease Product Stock
    private String id;
}
