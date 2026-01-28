package br.com.ambev.order_api.application.controller.dto.response;

import br.com.ambev.order_api.core.enums.StatusOrder;

import java.time.LocalDateTime;
import java.util.List;

public record CreateOrderResponse(
        String nrOrder,
        StatusOrder status,
        List<CreateItemOrderResponse> items,
        LocalDateTime createdAt

) { }
