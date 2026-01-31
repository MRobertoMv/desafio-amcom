package br.com.ambev.order_api.core.business;

import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.enums.StatusOrder;

import java.util.List;

public interface OrderBusiness {
    Order createOrder(Order order);

    Order calculateItems(Order order);

    List<Order> getOrderByStatus(StatusOrder status);

}
