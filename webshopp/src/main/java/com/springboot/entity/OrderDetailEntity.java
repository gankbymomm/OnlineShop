package com.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderdetails")
public class OrderDetailEntity extends BaseEntity {

	@Column(name = "unit_price")
    private double unitPrice;
	
	@Column(name = "quantity")
    private int quantity;
	
	@Column(name = "discount")
    private double discount;

    @ManyToOne
    @JoinColumn(name="orderId")
    OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name="productId")
    ProductEntity productEntity;


    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
