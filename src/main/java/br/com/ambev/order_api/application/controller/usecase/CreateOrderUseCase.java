package br.com.ambev.order_api.application.controller.usecase;

import br.com.ambev.order_api.core.domain.Order;

public interface CreateOrderUseCase {
    Order createOrder(Order order);
}
