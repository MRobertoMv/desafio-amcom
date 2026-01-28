package br.com.ambev.order_api.infraestructure.mapper;

import br.com.ambev.order_api.core.domain.Order;
import br.com.ambev.order_api.infraestructure.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity modelToEntity(Order order);

    Order entityToModel(OrderEntity orderEntity);
}
