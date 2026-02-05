package br.com.ambev.order_api.infraestructure.message.kafka.consumer;

import br.com.ambev.order_api.core.business.OrderBusiness;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.message.ReceiveOrderCalculationMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class ReceiveOrderCalculationMessageConsumer implements ReceiveOrderCalculationMessage {

    private static final Logger log = LogManager.getLogger(ReceiveOrderCalculationMessageConsumer.class);

    private final OrderBusiness orderBusiness;
    private final ObjectMapper objectMapper;

    public ReceiveOrderCalculationMessageConsumer(OrderBusiness orderBusiness, ObjectMapper objectMapper) {
        this.orderBusiness = orderBusiness;
        this.objectMapper = objectMapper;
    }


    @KafkaListener(
            topics = "${app.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void listenerOrderToCalculate(String strOrder) throws InterruptedException {
        log.info("listenerOrderToCalculate order: {}", strOrder);
        Thread.sleep(20000);
        receiveOrderToCalculate(objectMapper.readValue(strOrder, Order.class));
    }

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
