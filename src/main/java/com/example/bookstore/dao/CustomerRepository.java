package com.example.bookstore.dao;

import com.example.bookstore.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByCustomerEmail(String email);

    List<Customer>  findCustomerByCustomerEmailAndCustomerPassword(String email, String password);
}
