package com.dgn.relationship.controller;

import com.dgn.relationship.model.Customer;
import com.dgn.relationship.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }
    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok().build();
    }
}
