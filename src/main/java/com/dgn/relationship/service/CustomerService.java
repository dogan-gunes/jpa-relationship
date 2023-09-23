package com.dgn.relationship.service;

import com.dgn.relationship.model.Customer;
import com.dgn.relationship.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
