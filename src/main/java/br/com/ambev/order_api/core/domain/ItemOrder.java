package br.com.ambev.order_api.core.domain;

import br.com.ambev.order_api.core.exceptions.OrderBadRequestException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemOrder (
        Long nroItem,
        Long codProduct,
        Double qty,
        BigDecimal vlUnit,
        LocalDateTime createdAt
) {
    public ItemOrder {
        if (nroItem == null ||  nroItem < 1) {
            throw new OrderBadRequestException("Nro item null or invalid");
        }

        if (codProduct == null ||  codProduct < 3) {
            throw new OrderBadRequestException("Code product null or invalid");
        }

        if (qty == null || qty < 1.0) {
            throw new OrderBadRequestException("Quantity of items null or invalid");
        }

        if (vlUnit == null || vlUnit.doubleValue() < 0.0) {
            throw new OrderBadRequestException("Unit value is null or invalid");
        }

        if (createdAt == null) {
            throw new OrderBadRequestException("Item created at is required");
        }
    }
}
