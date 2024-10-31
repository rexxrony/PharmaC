package com.rex.pharmaC.service;

import com.rex.pharmaC.entity.Medicine;
import com.rex.pharmaC.entity.Order;
import com.rex.pharmaC.entity.OrderItem;
import com.rex.pharmaC.repository.MedicineRepository;
import com.rex.pharmaC.repository.OrderItemRepository;
import com.rex.pharmaC.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private OrderRepository orderRepository;

    public String addOrderItem(long medId, long orderId, int qtyOrderItem) {
        Optional<Order> orderDetails = orderRepository.findById(orderId);

        if (orderDetails.isPresent()) {
            Order order = orderDetails.get();
            Optional<Medicine> medicineDetails = medicineRepository.findById(medId);

            if (medicineDetails.isPresent()) {
                Medicine medicine = medicineDetails.get();

                // Create and calculate new OrderItem
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setMedicine(medicine);
                orderItem.setQtyOrderItem(qtyOrderItem);
                float priceOfItem = medicine.getMedPrice() * qtyOrderItem;
                orderItem.setPriceOfItem(priceOfItem);

                // Update order's total amount
                order.setTotalAmount(order.getTotalAmount() + priceOfItem);
                orderRepository.save(order);

                // Save order item
                orderItemRepository.save(orderItem);

                return "Order item added successfully!";
            } else {
                return "Medicine not found";
            }
        } else {
            return "Order not found";
        }
    }

    public List<OrderItem> getOrderItem() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(long id) {
        return orderItemRepository.findById(id);
    }

    public String updateOrderItem(OrderItem updatedOrderItem) {
        Optional<OrderItem> existingOrderItemOpt = orderItemRepository.findById(updatedOrderItem.getId());

        if (existingOrderItemOpt.isPresent()) {
            OrderItem existingOrderItem = existingOrderItemOpt.get();
            Order order = existingOrderItem.getOrder();

            // Adjust order total: subtract old price, add new price
            order.setTotalAmount(order.getTotalAmount() - existingOrderItem.getPriceOfItem());

            // Update quantity and recalculate price
            int newQty = updatedOrderItem.getQtyOrderItem();
            float newPriceOfItem = existingOrderItem.getMedicine().getMedPrice() * newQty;
            existingOrderItem.setQtyOrderItem(newQty);
            existingOrderItem.setPriceOfItem(newPriceOfItem);

            // Update order's total amount
            order.setTotalAmount(order.getTotalAmount() + newPriceOfItem);
            orderRepository.save(order);
            orderItemRepository.save(existingOrderItem);

            return "Order item updated successfully!";
        } else {
            return "Order item not found!";
        }
    }

    public String removeOrderItemById(long id) {
        Optional<OrderItem> orderItemOpt = orderItemRepository.findById(id);

        if (orderItemOpt.isPresent()) {
            OrderItem orderItem = orderItemOpt.get();
            Order order = orderItem.getOrder();

            // Adjust order's total amount
            order.setTotalAmount(order.getTotalAmount() - orderItem.getPriceOfItem());
            orderRepository.save(order);

            // Delete the order item
            orderItemRepository.deleteById(id);

            return "Order item removed successfully!";
        } else {
            return "Order item not found!";
        }
    }

    public List<OrderItem> getOrderItemByOrderId(long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
}
