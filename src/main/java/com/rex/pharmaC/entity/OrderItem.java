package com.rex.pharmaC.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    Order order;

    @ManyToOne
    @JoinColumn(name = "medId", nullable = false)
    Medicine medicine;

    int qtyOrderItem;
    float priceOfItem;

}
