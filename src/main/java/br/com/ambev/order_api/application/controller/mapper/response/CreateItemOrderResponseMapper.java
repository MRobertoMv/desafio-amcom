package br.com.ambev.order_api.application.controller.mapper.response;

import br.com.ambev.order_api.application.controller.dto.response.CreateItemOrderResponse;
import br.com.ambev.order_api.core.domain.ItemOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateItemOrderResponseMapper {
    public CreateItemOrderResponse modelToDto(ItemOrder item) {
        return new CreateItemOrderResponse(
                item.nroItem(),
                item.codProduct(),
                item.qty(),
                item.vlUnit()
        );
    }

    public List<CreateItemOrderResponse> modelToDto(List<ItemOrder> items) {
        return items.stream()
                .map(this::modelToDto)
                .toList();
    }


}
