package br.com.ambev.order_api.application.controller;

import br.com.ambev.order_api.application.controller.dto.request.CreateOrderRequest;
import br.com.ambev.order_api.application.controller.dto.response.CreateOrderResponse;
import br.com.ambev.order_api.application.controller.mapper.request.CreateOrderRequestMapper;
import br.com.ambev.order_api.application.controller.mapper.response.CreateOrderResponseMapper;
import br.com.ambev.order_api.application.controller.usecase.CreateOrderUseCase;
import br.com.ambev.order_api.application.controller.usecase.GetOrderCalculated;
import br.com.ambev.order_api.core.domain.OrderCalculated;
import br.com.ambev.order_api.core.enums.StatusOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final CreateOrderRequestMapper createOrderRequestMapper;
    private final CreateOrderResponseMapper createOrderResponseMapper;
    private final GetOrderCalculated getOrderCalculated;

    public OrderController(CreateOrderUseCase createOrderUseCase, CreateOrderRequestMapper createOrderRequestMapper, CreateOrderResponseMapper createOrderResponseMapper, GetOrderCalculated getOrderCalculated) {
        this.createOrderUseCase = createOrderUseCase;
        this.createOrderRequestMapper = createOrderRequestMapper;
        this.createOrderResponseMapper = createOrderResponseMapper;
        this.getOrderCalculated = getOrderCalculated;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest order){
        return createOrderResponseMapper.modelToDto(
                createOrderUseCase.createOrder(createOrderRequestMapper.dtoToDomain(order))
        );
    }

    @GetMapping("/calculated")
    public ResponseEntity<OrderCalculated> getOrderCalculated() {
        return ResponseEntity.ok(getOrderCalculated.getOrderByStatus(StatusOrder.CALCULATION_OK));
    }
}
