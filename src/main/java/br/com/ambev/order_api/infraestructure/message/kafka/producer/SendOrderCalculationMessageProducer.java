package br.com.ambev.order_api.infraestructure.message.kafka.producer;

import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.message.SendOrderCalculationMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendOrderCalculationMessageProducer implements SendOrderCalculationMessage {

    private static final Logger log = LogManager.getLogger(SendOrderCalculationMessageProducer.class);

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${app.topic.name}")
    private String topic;

    public SendOrderCalculationMessageProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrderToCalculate(Order order) {
        log.info("sending order to calculate: {}", order.nrOrder());
        String key = order.nrOrder();
        kafkaTemplate.send(topic, key, order);
        log.info("order send to calculate ok: {}", order.nrOrder());

    }
}
