package com.example.bookstore.controllers;

import com.example.bookstore.models.Customer;
import com.example.bookstore.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/customer")
    private List<Customer> getAll(){
        return service.getAllCustomer();
    }
    @GetMapping("/customerById/{id}")
    private Customer getById(@PathVariable Long id){
        return service.getCustomerById(id);
    }

    @PostMapping("/saveCustomer")
    public Object setCustomer(@Valid @RequestBody Customer customer){
        return service.registration(customer);
    }

    @GetMapping("/customer/login")
    public Object loginCustomer(@RequestParam("customerEmail") String customerEmail, @RequestParam("customerPassword") String customerPassword){
        return service.validate(customerEmail, customerPassword);
    }


    @PutMapping("/updateCustomerById/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return new ResponseEntity<Customer>(
                service.updateCustomer(id, customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomerById/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return service.deleteCustomerById(id);
    }
}
