package br.com.ambev.order_api.application.controller.usecase;

import br.com.ambev.order_api.core.domain.OrderCalculated;
import br.com.ambev.order_api.core.enums.StatusOrder;

public interface GetOrderCalculated {
    OrderCalculated getOrderByStatus(StatusOrder status);
}
