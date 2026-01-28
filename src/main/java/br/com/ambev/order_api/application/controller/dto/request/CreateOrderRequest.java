package br.com.ambev.order_api.application.controller.dto.request;

import br.com.ambev.order_api.core.exceptions.OrderBadRequestException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record CreateOrderRequest(
        String nrOrder,
        List<CreateItemOrderRequest> items
) {

    public CreateOrderRequest {
        if (nrOrder == null || nrOrder.isBlank() || nrOrder.length() < 5) {
            throw new OrderBadRequestException("Nro order null or invalid. Please enter a valid order number with at least 5 characters");
        }

        if (items == null || items.isEmpty()) {
            throw new OrderBadRequestException("Items is required");
        } else {
            Map<Long, List<CreateItemOrderRequest>> duplicates = items.stream()
                    .collect(Collectors.groupingBy(CreateItemOrderRequest::nroItem))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue().size() > 1)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            if (!duplicates.isEmpty()) {
                throw new OrderBadRequestException("Order contains duplicate items");
            }

        }
    }
}
