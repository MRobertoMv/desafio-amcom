package br.com.ambev.order_api.core.business;

import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.domain.OrderCalculated;
import br.com.ambev.order_api.core.enums.StatusOrder;

public interface OrderBusiness {
    Order createOrder(Order order);

    void calculateItems(Order order);

    OrderCalculated getOrderByStatus(StatusOrder status);

}
