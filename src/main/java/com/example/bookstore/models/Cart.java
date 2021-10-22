package com.example.bookstore.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Entity
public class Cart {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	private Collection <Book> books;

	private float cartPrice;

	@ManyToOne
	@JoinColumn(name="order_id")
	private Orders orders;

	public Cart() {
		this.cartPrice=0;
	}
	public Long getId() {
	return id;
}

	public void setId(Long id) {
	this.id = id;
}

	public Collection<Book> getBooks() {
	return this.books;
}

	public void setBooks(Collection<Book> books) {
	this.books = books;
}

	public float getCartPrice() {
	return cartPrice;
}

	public void setCartPrice(float cartPrice) {
	this.cartPrice = cartPrice;
}

	@Override
	public String toString() {
	return "Cart [id=" + id + ", products=" + books + ", cartPrice=" + cartPrice + "]";
}
	}
