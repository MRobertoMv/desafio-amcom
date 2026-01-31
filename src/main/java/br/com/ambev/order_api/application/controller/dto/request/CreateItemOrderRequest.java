package br.com.ambev.order_api.application.controller.dto.request;

import br.com.ambev.order_api.core.exceptions.OrderBadRequestException;

import java.math.BigDecimal;

public record CreateItemOrderRequest(
        Long nrItem,
        Long codProduct,
        Double qty,
        BigDecimal vlUnit
) {
    public CreateItemOrderRequest {
        if (nrItem == null ||  nrItem < 1) {
            throw new OrderBadRequestException("Number item null or invalid");
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
    }
}
