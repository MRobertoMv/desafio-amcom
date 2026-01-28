package br.com.ambev.order_api.infraestructure.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_order")
public class ItemOrderEntity implements Serializable {

    @EmbeddedId
    private ItemOrderPk id;

    private Long codProduct;
    private Double qty;
    private BigDecimal vlUnit;
    private LocalDateTime createdAt;

    private LocalDateTime updateddAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false) // Creates a foreign key column in ORDER_ITEMS table
    private OrderEntity order;

    public ItemOrderPk getId() {
        return id;
    }

    public void setId(ItemOrderPk id) {
        this.id = id;
    }

    public Long getCodProduct() {
        return codProduct;
    }

    public void setCodProduct(Long codProduct) {
        this.codProduct = codProduct;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public BigDecimal getVlUnit() {
        return vlUnit;
    }

    public void setVlUnit(BigDecimal vlUnit) {
        this.vlUnit = vlUnit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateddAt() {
        return updateddAt;
    }

    public void setUpdateddAt(LocalDateTime updateddAt) {
        this.updateddAt = updateddAt;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
