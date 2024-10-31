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

//    @ManyToOne
//    @JoinColumn(name = "orderId", nullable = false)
//    Order order;

    Long orderId; //reciept no

//    @ManyToOne
//    @JoinColumn(name = "medId", nullable = false)

    Long medicineId;

    int qtyOrderItem;
    float priceOfItem;

}
