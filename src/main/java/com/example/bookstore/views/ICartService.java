package com.example.bookstore.views;


import com.example.bookstore.models.Cart;

import java.util.List;

public interface ICartService {
    public Cart saveCart(Cart c) ;
    public List<Cart> getCarts();
    public Cart updating(Cart c) ;
    public Cart empty(long id) ;
    public Cart addToCart(long cid,String isbn) ;
    public Cart removeFromCart(long cid, String isbn);
    public void deleting(long id);
}
