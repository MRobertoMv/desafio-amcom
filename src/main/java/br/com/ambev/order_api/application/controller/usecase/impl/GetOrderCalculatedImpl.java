package br.com.ambev.order_api.application.controller.usecase.impl;

import br.com.ambev.order_api.application.controller.usecase.GetOrderCalculated;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.enums.StatusOrder;

import java.util.List;

public class GetOrderCalculatedImpl implements GetOrderCalculated {
    @Override
    public List<Order> getOrderByStatus(StatusOrder status) {
        return List.of();
    }
}
