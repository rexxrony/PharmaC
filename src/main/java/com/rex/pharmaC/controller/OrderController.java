package com.rex.pharmaC.controller;

import com.rex.pharmaC.entity.Order;
import com.rex.pharmaC.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //api for starting a new order
    @PostMapping("/{customerId}")
    public Object addOrder(@PathVariable long customerId){
        return orderService.addOrder(customerId);
    }

    @GetMapping
    public List<Order> getOrders(){
        return  orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable long id){
        return orderService.getOrderById(id);
    }

    //Update is not required here

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable long id){
        return orderService.deleteOrder(id);
    }
}
