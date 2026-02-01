package br.com.ambev.order_api.application.controller.usecase.impl;

import br.com.ambev.order_api.application.controller.usecase.GetOrderCalculated;
import br.com.ambev.order_api.core.domain.OrderCalculated;
import br.com.ambev.order_api.core.enums.StatusOrder;
import br.com.ambev.order_api.infraestructure.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class GetOrderCalculatedImpl implements GetOrderCalculated {
    private final OrderService orderService;

    public GetOrderCalculatedImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public OrderCalculated getOrderByStatus(StatusOrder status) {
        return orderService.getOrderByStatus(status);
    }
}
