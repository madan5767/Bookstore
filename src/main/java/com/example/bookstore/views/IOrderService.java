package com.example.bookstore.views;

import com.example.bookstore.models.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> getAllOrders();
    Orders addOrder(Orders orders);
}
