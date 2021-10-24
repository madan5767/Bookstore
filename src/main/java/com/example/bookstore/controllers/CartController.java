package com.example.bookstore.controllers;


import com.example.bookstore.models.Cart;
import com.example.bookstore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "Cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@GetMapping
	public List<Cart> carts(){
		return cartService.getCarts();	
	}
	
	@GetMapping("/")
	public List<Cart>getCarts(){
		return cartService.getCarts();	
	}

	//Insert
	@PostMapping(value="/add" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Cart creerCart(@RequestBody Cart c) {
		return cartService.saveCart(c);

	}
	//Modifier
	@PutMapping(path="/modifie/{id}")
	public Cart update(@PathVariable(name="id")long id, @RequestBody Cart c) {
		c.setCartId(id);
		return cartService.saveCart(c);
	}
	//EmptyCart
	@PutMapping(path="/empty/{id}")
	public Cart empty(@PathVariable(name="id")long id) {
		return cartService.empty(id);
	}

	//Supprimer
	@DeleteMapping(path="/delete/{id}")
	public boolean delete(@PathVariable(name="id") long id) {
		cartService.deleting(id);
		return true;
	}

	//addProduct
	@PutMapping(path="/addP/{cid}/{pid}")
	public Cart addProduct(@PathVariable(name="cid")long cid,@PathVariable(name="pid")String isbn) {
		return cartService.addToCart(cid, isbn);
	}

	//removeProduct
	@PutMapping(path="/removeP/{cid}/{pid}")
	public Cart removeProduct(@PathVariable(name="cid")long cid,@PathVariable(name="pid")String isbn) {
		return cartService.removeFromCart(cid, isbn);
	}

	@DeleteMapping(path="/deleteAll")
	public boolean deleteEvreything() {
		cartService.deleteEvreything();
		return true;
	}

}
