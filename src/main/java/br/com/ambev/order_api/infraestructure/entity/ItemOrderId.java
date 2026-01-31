package br.com.ambev.order_api.infraestructure.entity;

import java.io.Serializable;
import java.util.Objects;

public class ItemOrderId implements Serializable {
    private Long orderId;

    private Long nroItem;

    public ItemOrderId() {
    }

    public ItemOrderId(Long orderId, Long nroItem) {
        this.orderId = orderId;
        this.nroItem = nroItem;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getNroItem() {
        return nroItem;
    }

    public void setNroItem(Long nroItem) {
        this.nroItem = nroItem;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemOrderId that)) return false;
        return Objects.equals(orderId, that.orderId) && Objects.equals(nroItem, that.nroItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, nroItem);
    }
}
