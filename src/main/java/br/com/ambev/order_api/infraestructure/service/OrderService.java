package br.com.ambev.order_api.infraestructure.service;

import br.com.ambev.order_api.core.business.OrderBusiness;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.enums.StatusOrder;
import br.com.ambev.order_api.core.exceptions.DuplicateNrOrderException;
import br.com.ambev.order_api.infraestructure.entity.OrderEntity;
import br.com.ambev.order_api.infraestructure.mapper.OrderMapper;
import br.com.ambev.order_api.infraestructure.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService implements OrderBusiness {

    private static final Logger log = LogManager.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    @Override
    public Order createOrder(Order order) {

        ;
        if (orderRepository.findByNrOrder(order.nrOrder()) != null){
            throw new DuplicateNrOrderException("Number order existis: ".concat(order.nrOrder()));
        }

        OrderEntity orderEntity = orderMapper.modelToEntity(order);

        orderEntity.setOrdemItems();

        OrderEntity orderEntitySave = orderRepository.save(orderEntity);

        return orderMapper.entityToModel(orderEntitySave);

    }

    @Override
    public void calculateItems(Order order) {

        OrderEntity orderEntity = orderRepository.findByNrOrder(order.nrOrder());

        if (!StatusOrder.NEW_ORDER.equals( orderEntity.getStatus())) {
            log.error("Invalid order to calculate status not NEW_ORDER, order: {}", order);
            return;
        }

        BigDecimal total = orderEntity.getItems().stream()
                .map(item -> item.getVlUnit().multiply(BigDecimal.valueOf(item.getQty()))) // Map to total price per item
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        orderEntity.setVlTotal(total);
        orderEntity.setStatus(StatusOrder.CALCULATION_OK);
        orderRepository.save(orderEntity);
    }

    @Override
    public List<Order> getOrderByStatus(StatusOrder status) {
        return List.of();
    }
}
