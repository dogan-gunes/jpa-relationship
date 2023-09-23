package com.dgn.relationship.service;

import com.dgn.relationship.model.Customer;
import com.dgn.relationship.model.Order;
import com.dgn.relationship.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerService customerService;

    public OrderService(OrderRepository orderRepository, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    public Order addOrder(Order order, Long customerId){
         Customer customer = customerService.getCustomerById(customerId);
         order.setCustomer(customer);
         return orderRepository.save(order);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

}
