package com.example.bookstore.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
public class Book implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(13)")
    private String isbn;
    private String title;
    private String Author;
    @Column(columnDefinition = "double default 0.0")
    private float price;
    @Column(columnDefinition = "integer default 0")
    private int numberTimesBought;
    @Column(columnDefinition = "double default 0.0")
    private double averageRatings;
    @Column(columnDefinition = "integer default 0")
    private int nbRatings;
    @Column(columnDefinition = "varchar(500) default 'No description provided for this Book'")
    private String description;
    @Column(columnDefinition = "varchar(3000) default 'C:\timage\tharrypotter.jpg'")
    private String cover;
    private int quantity;
    private boolean archived;
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Category> categories;
//    @JsonIgnore
//    @OneToMany( mappedBy="book" )
//    private List<Resource> resources = new ArrayList<>();

    @OneToOne(mappedBy = "book")
    private ArchiveBook archiveBook;

    @OneToMany
    private List<Review> reviews;

    public Book() {
    }

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

	public Book(String isbn, String title, String author, float price, String cover, String description, Collection<Category> categories) {
        this.isbn = isbn;
        this.title = title;
        Author = author;
        this.price = price;
        this.cover = cover;
        this.description = description;
        this.categories = categories;
        archived=false;

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberTimesBought() {
        return numberTimesBought;
    }

    public void setNumberTimesBought(int numberTimesBought) {
        this.numberTimesBought = numberTimesBought;
    }

    public double getAverageRatings() {
        return averageRatings;
    }

    public void setAverageRatings(double averageRatings) {
        this.averageRatings = averageRatings;
    }

    public int getNbRatings() {
        return nbRatings;
    }

    public void setNbRatings(int nbRatings) {
        this.nbRatings = nbRatings;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Category> getCategories() {return categories;}

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
