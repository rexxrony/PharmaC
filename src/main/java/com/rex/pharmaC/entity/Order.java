package com.rex.pharmaC.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    Customer customer;

    List<OrderItem> orderItemList;

    LocalDate orderDate;
    float totalAmount;



}
