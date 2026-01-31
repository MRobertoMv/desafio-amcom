package br.com.ambev.order_api.application.controller.mapper.request;

import br.com.ambev.order_api.application.controller.dto.request.CreateItemOrderRequest;
import br.com.ambev.order_api.core.domain.ItemOrder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CreateItemOrderRequestMapper {
    public ItemOrder dtoToDomain(CreateItemOrderRequest item) {
        return new ItemOrder(
                item.nrItem(),
                item.codProduct(),
                item.qty(),
                item.vlUnit(),
                LocalDateTime.now());
    }

    public List<ItemOrder> dtoToDomain(List<CreateItemOrderRequest> items) {
        return items.stream()
                .map(this::dtoToDomain)
                .toList();
    }
}
