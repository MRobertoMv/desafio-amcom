package br.com.ambev.order_api.application.controller.usecase.impl;

import br.com.ambev.order_api.application.controller.usecase.CreateOrderUseCase;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.message.SendOrderCalculationMessage;
import br.com.ambev.order_api.infraestructure.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderService orderService;
    private final SendOrderCalculationMessage sendOrderCalculationMessage;

    public CreateOrderUseCaseImpl(OrderService orderService, SendOrderCalculationMessage sendOrderCalculationMessage) {
        this.orderService = orderService;
        this.sendOrderCalculationMessage = sendOrderCalculationMessage;
    }

    @Override
    public Order createOrder(Order order) {
        Order orderResult = orderService.createOrder(order);
        sendOrderToCalculate(orderResult);
        return orderResult;
    }

    public void sendOrderToCalculate(Order order) {
        sendOrderCalculationMessage.sendOrderToCalculate(order);
    }
}
