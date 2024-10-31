package com.rex.pharmaC.service;

import com.rex.pharmaC.entity.Customer;
import com.rex.pharmaC.entity.Order;
import com.rex.pharmaC.repository.CustomerRepository;
import com.rex.pharmaC.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public String addOrder(long customerId) {
        Optional<Customer> customer =customerRepository.findById(customerId);
        if(customer.isPresent()){
            Order order = new Order();
            order.setOrderDate(LocalDate.now());
            order.setCustomer(customer.get());
            orderRepository.save(order);
        }
        else {
            return "Customer not found";
        }

        return "Order Placed Successfully!";
    }


    public List<Order> getOrders() {
        return orderRepository.findAll();
    }


    public Optional<Order> getOrderById(long id) {
        return orderRepository.findById(id);
    }


    //update is not required for this

    public String deleteOrder(long id) {
        orderRepository.deleteById(id);
        return "Order Deleted Successfully!";
    }
}
