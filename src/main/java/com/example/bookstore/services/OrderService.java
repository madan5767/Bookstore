package com.example.bookstore.services;

import com.example.bookstore.dao.OrderRepository;
import com.example.bookstore.models.Book;
import com.example.bookstore.models.Orders;
import com.example.bookstore.views.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Override
    public List<Orders> getAllOrders(){
        List<Orders> orders = new ArrayList<Orders>();
        orderRepository.findAll().forEach(orders::add);
        logger.info("retrieved list of books: " + orders);
        return orders;
    }

    @Override
    public Orders addOrder(Orders orders) {
        orderRepository.save(orders);
        return orders;
    }

}
