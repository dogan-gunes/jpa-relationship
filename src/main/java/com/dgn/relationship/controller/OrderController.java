package com.dgn.relationship.controller;

import com.dgn.relationship.model.Order;
import com.dgn.relationship.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addOrder/{customerId}")
    public ResponseEntity<Order> addOrder(@RequestBody Order order,
                                          @PathVariable Long customerId) {
        return new ResponseEntity<>(orderService.addOrder(order, customerId), HttpStatus.CREATED);
    }

    @GetMapping("/getAllOrder")
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
