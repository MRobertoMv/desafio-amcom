package br.com.ambev.order_api.infraestructure.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemOrderPk implements Serializable {

    private Long orderId;
    private Long nroItem;

    public ItemOrderPk(Long orderId, Long nroItem) {
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
        if (!(o instanceof ItemOrderPk that)) return false;
        return Objects.equals(orderId, that.orderId) && Objects.equals(nroItem, that.nroItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, nroItem);
    }
}
