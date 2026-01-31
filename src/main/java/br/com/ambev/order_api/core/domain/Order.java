package br.com.ambev.order_api.core.domain;

import br.com.ambev.order_api.core.enums.StatusOrder;
import br.com.ambev.order_api.core.exceptions.OrderBadRequestException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record Order(
        String nrOrder,
        StatusOrder status,
        BigDecimal vlTotal,
        List<ItemOrder> items,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public Order {

        if (nrOrder == null || nrOrder.isBlank() || nrOrder.length() < 5) {
            throw new OrderBadRequestException("Nro order null or invalid. Please enter a valid order number with at least 5 characters");
        }

        if (status == null) {
            throw new OrderBadRequestException("Status is required");
        } else if (!StatusOrder.NEW_ORDER.equals(status)) {
            throw new OrderBadRequestException("Status invalid for new order");
        }

        if (createdAt == null) {
            throw new OrderBadRequestException("Created at is required");
        }

        if (items == null || items.isEmpty()) {
            throw new OrderBadRequestException("items is required");
        } else {
            Map<Long, List<ItemOrder>> duplicates = items.stream()
                    .collect(Collectors.groupingBy(ItemOrder::nrItem))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue().size() > 1)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            if (!duplicates.isEmpty()) {
                throw new OrderBadRequestException("Order contains duplicate items");
            }

        }

    }

    public Order(
                 String nro_order,
                 StatusOrder status,
                 BigDecimal vlTotal,
                 List<ItemOrder> items) {
        this(nro_order, status, vlTotal, items, LocalDateTime.now(), null);
    }

    public Order updateVlTotal(BigDecimal vlTotal) {
        if (vlTotal == null || vlTotal.doubleValue() < 0.0) {
            throw new OrderBadRequestException("Total value is null or invalid");
        }
        return new Order(
                this.nrOrder,
                this.status,
                vlTotal,
                this.items,
                this.createdAt,
                LocalDateTime.now());
    }

    public Order updateStatus(StatusOrder status) {
        if (status == null) {
            throw new OrderBadRequestException("Status is required");
        } else if (status == this.status) {
            throw new OrderBadRequestException("Enter a different status to update");
        }

        return new Order(
                this.nrOrder,
                status,
                this.vlTotal,
                this.items,
                this.createdAt,
                LocalDateTime.now());
    }

}
