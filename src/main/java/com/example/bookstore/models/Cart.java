package com.example.bookstore.models;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartId;

	private Long cartQuantity;

	private float cartPrice;

	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Book> books;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders orders;

}

