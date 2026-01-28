package br.com.ambev.order_api.application.controller.mapper.request;

import br.com.ambev.order_api.application.controller.dto.request.CreateOrderRequest;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.enums.StatusOrder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreateOrderRequestMapper {

    private final CreateItemOrderRequestMapper createItemOrderRequestMapper;

    public CreateOrderRequestMapper(CreateItemOrderRequestMapper createItemOrderRequestMapper) {
        this.createItemOrderRequestMapper = createItemOrderRequestMapper;
    }

    public Order dtoToDomain(CreateOrderRequest order) {
        return new Order(
                order.nrOrder(),
                StatusOrder.NEW_ORDER,
                new BigDecimal("0.0"),
                createItemOrderRequestMapper.dtoToDomain(order.items()));
    }
}
