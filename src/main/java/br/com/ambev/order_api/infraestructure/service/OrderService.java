package br.com.ambev.order_api.infraestructure.service;

import br.com.ambev.order_api.core.OrderBusiness;
import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.core.enums.StatusOrder;
import br.com.ambev.order_api.infraestructure.entity.OrderEntity;
import br.com.ambev.order_api.infraestructure.mapper.OrderMapper;
import br.com.ambev.order_api.infraestructure.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderBusiness {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    @Override
    public Order createOrder(Order order) {

        OrderEntity orderEntity = orderMapper.modelToEntity(order);

        orderEntity.setOrdemItems();

        OrderEntity orderEntitySave = orderRepository.save(orderEntity);

        Order orderResult = orderMapper.entityToModel(orderEntitySave);

        return orderResult;

    }

    @Override
    public Order calculateItems(Order order) {
        return null;
    }

    @Override
    public List<Order> getOrderByStatus(StatusOrder status) {
        return List.of();
    }
}
