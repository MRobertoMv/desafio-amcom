package br.com.ambev.order_api.application.controller.usecase;

import br.com.ambev.order_api.core.domain.Order;

import java.util.concurrent.CompletableFuture;

public interface CreateOrderUseCase {
    Order createOrder(Order order);

    CompletableFuture<Void> sendOrderToCalculate(Order order);
}
