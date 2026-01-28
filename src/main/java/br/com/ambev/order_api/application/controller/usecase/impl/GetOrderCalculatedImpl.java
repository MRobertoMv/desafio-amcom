package br.com.ambev.order_api.application.controller.usecase.impl;

import br.com.ambev.order_api.application.controller.usecase.GetOrderCalculated;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.enums.StatusOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOrderCalculatedImpl implements GetOrderCalculated {
    @Override
    public List<Order> getOrderByStatus(StatusOrder status) {
        return List.of();
    }
}
