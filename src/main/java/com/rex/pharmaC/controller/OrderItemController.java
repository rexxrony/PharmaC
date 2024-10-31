package com.rex.pharmaC.controller;

import com.rex.pharmaC.entity.OrderItem;
import com.rex.pharmaC.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public String addOrderItem(@RequestParam long medId, @RequestParam long orderId, @RequestParam int qtyOrderItem){
        return orderItemService.addOrderItem(medId,orderId,qtyOrderItem);
    }

    @GetMapping
    public List<OrderItem> getOrderItem(){
        return orderItemService.getOrderItem();
    }

    @GetMapping("/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable long id){
        return orderItemService.getOrderItemById(id);
    }

    @PutMapping
    public String updateOrderItem(@RequestBody OrderItem orderItem){
        return orderItemService.updateOrderItem(orderItem);
    }

    @DeleteMapping("/{id}")
    public String removeOrderItemById(@PathVariable long id){
        return orderItemService.removeOrderItemById(id);
    }

    //api for fetching all orderitems when an order id is given
    @GetMapping("/byOrder/{orderId}")
    public List<OrderItem> getOrderItemByOrderId(@PathVariable long orderId){
        return orderItemService.getOrderItemByOrderId(orderId);
    }
}
