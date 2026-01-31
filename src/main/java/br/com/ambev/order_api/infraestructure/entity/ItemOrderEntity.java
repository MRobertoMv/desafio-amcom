package br.com.ambev.order_api.infraestructure.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_item_order")
public class ItemOrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_order_generator")
    @SequenceGenerator(name = "item_order_generator", sequenceName = "tb_item_order_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nr_item")
    private Long nrItem;

    @Column(name = "cd_product")
    private Long codProduct;
    private Double qty;

    private BigDecimal vlUnit;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    public ItemOrderEntity() {
    }

    public ItemOrderEntity(Long nrItem, Long codProduct, Double qty, BigDecimal vlUnit, LocalDateTime createdAt, LocalDateTime updatedAt, OrderEntity order) {
        this.nrItem = nrItem;
        this.codProduct = codProduct;
        this.qty = qty;
        this.vlUnit = vlUnit;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.order = order;
    }

    public ItemOrderEntity(long id, Long nrItem, Long codProduct, Double qty, BigDecimal vlUnit, LocalDateTime createdAt, LocalDateTime updatedAt, OrderEntity order) {
        this.id = id;
        this.nrItem = nrItem;
        this.codProduct = codProduct;
        this.qty = qty;
        this.vlUnit = vlUnit;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getNrItem() {
        return nrItem;
    }

    public void setNrItem(Long nrItem) {
        this.nrItem = nrItem;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemOrderEntity that)) return false;
        return Objects.equals(nrItem, that.nrItem) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrItem, order);
    }
}
