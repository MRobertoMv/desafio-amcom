package br.com.ambev.order_api.application.controller.dto.response;

import java.math.BigDecimal;

public record CreateItemOrderResponse(
        Long nrItem,
        Long codProduct,
        Double qty,
        BigDecimal vlUnit
) { }
