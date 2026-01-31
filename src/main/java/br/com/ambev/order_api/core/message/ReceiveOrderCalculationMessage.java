package br.com.ambev.order_api.core.message;

import br.com.ambev.order_api.core.domain.Order;

public interface ReceiveOrderCalculationMessage {
    void receiveOrderToCalculate (Order order) ;
}
