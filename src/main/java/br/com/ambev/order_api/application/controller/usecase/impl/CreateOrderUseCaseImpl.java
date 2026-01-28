package br.com.ambev.order_api.application.controller.usecase.impl;

import br.com.ambev.order_api.application.controller.usecase.CreateOrderUseCase;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.infraestructure.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderService orderService;

    public CreateOrderUseCaseImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }
}
