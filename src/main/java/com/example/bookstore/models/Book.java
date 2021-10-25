package com.example.bookstore.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "book", schema = "finalbookstore", uniqueConstraints= {@UniqueConstraint(columnNames={"isbn"})})
public class Book implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(13)")
    private String isbn;
    private String title;
    private String Author;
    @Column(columnDefinition = "double default 0.0")
    private float price;
    @Column(columnDefinition = "varchar(500) default 'No description provided for this Book'")
    private String description;
//    @Column(columnDefinition = "varchar(3000) default 'C:\timage\tharrypotter.jpg'")

    private String cover;
    private int quantity;
    private boolean archived;
    private double averageRating;
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Category> category;

    @OneToOne(mappedBy = "book")
    private ArchiveBook archiveBook;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Book(String isbn, String title, String author, float price,String cover, String description) {
        this.isbn = isbn;
        this.title = title;
        Author = author;
        this.price = price;
        this.cover = cover;
        this.description = description;
        archived=false;
    }

    public Book(String isbn, String title, String author, float price) {
		this.isbn = isbn;
		this.title = title;
		Author = author;
		this.price = price;
	}

	public Book(String isbn, String title, String author, float price, String cover, String description, Collection<Category> category) {
        this.isbn = isbn;
        this.title = title;
        Author = author;
        this.price = price;
        this.cover = cover;
        this.description = description;
        this.category = category;
        archived=false;
    }
}