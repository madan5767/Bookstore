package com.example.bookstore.models;

import com.example.bookstore.enums.EOrder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date orderDate;
    private String shippingAddress;
    @Enumerated(EnumType.STRING)
    private EOrder orderStatus;
    private float orderTotal;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Cart> cart;
}
