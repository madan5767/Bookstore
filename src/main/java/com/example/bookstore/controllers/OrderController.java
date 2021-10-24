package com.example.bookstore.controllers;

import com.example.bookstore.models.Orders;
import com.example.bookstore.views.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping(path = "Order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping("/getAll")
    public ResponseEntity<Collection<Orders>> getAllOrders() {
        Collection<Orders> orders =orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/newOrder")
    public ResponseEntity<Orders> addOrder(@Valid @RequestBody Orders order) throws URISyntaxException {
        Orders result = orderService.addOrder(order);
        return ResponseEntity.created(new URI("/newOrder" + result.getOrderId())).body(result);
    }
}

