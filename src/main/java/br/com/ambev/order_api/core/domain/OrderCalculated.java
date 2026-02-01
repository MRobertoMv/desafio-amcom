package br.com.ambev.order_api.core.domain;

import java.util.List;

public record OrderCalculated(List<Order> orders) {
}
