package br.com.ambev.order_api.infraestructure.mapper;

import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.infraestructure.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity modelToEntity(Order order);

    List<OrderEntity> modelToEntity(List<Order> orders);
    @InheritInverseConfiguration
    Order entityToModel(OrderEntity orderEntity);

    @InheritInverseConfiguration
    List<Order> entityToModel(List<OrderEntity> orders);
}
