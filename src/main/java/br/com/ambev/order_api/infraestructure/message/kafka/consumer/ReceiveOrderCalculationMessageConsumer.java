package br.com.ambev.order_api.infraestructure.message.kafka.consumer;

import br.com.ambev.order_api.core.business.OrderBusiness;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.message.ReceiveOrderCalculationMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiveOrderCalculationMessageConsumer implements ReceiveOrderCalculationMessage {

    private static final Logger log = LogManager.getLogger(ReceiveOrderCalculationMessageConsumer.class);

    private final OrderBusiness orderBusiness;

    public ReceiveOrderCalculationMessageConsumer(OrderBusiness orderBusiness) {
        this.orderBusiness = orderBusiness;
    }

    @KafkaListener(
            topics = "${app.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    @Override
    public void receiveOrderToCalculate(Order order) {
        log.info("Calculating order: {}", order);
        if (order == null) {
            log.error("Invalid order to calculate: {}", order);
            return;
        }
        orderBusiness.calculateItems(order);
        log.info("Calculated order: {}, ok", order);

    }

}
