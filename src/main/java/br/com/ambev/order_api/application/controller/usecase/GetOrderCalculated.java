package br.com.ambev.order_api.application.controller.usecase;

import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.enums.StatusOrder;

import java.util.List;

public interface GetOrderCalculated {
    List<Order> getOrderByStatus(StatusOrder status);
}
