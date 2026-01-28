package br.com.ambev.order_api.application.controller.mapper.response;

import br.com.ambev.order_api.application.controller.dto.response.CreateOrderResponse;
import br.com.ambev.order_api.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderResponseMapper {

    private final CreateItemOrderResponseMapper createItemOrderResponseMapper;

    public CreateOrderResponseMapper(CreateItemOrderResponseMapper createItemOrderResponseMapper) {
        this.createItemOrderResponseMapper = createItemOrderResponseMapper;
    }

    public CreateOrderResponse modelToDto(Order order) {
        return new CreateOrderResponse(
                order.nrOrder(),
                order.status(),
                createItemOrderResponseMapper.modelToDto(order.items()),
                order.createdAt()
        );
    }

}
