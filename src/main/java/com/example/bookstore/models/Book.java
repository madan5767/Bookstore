package com.example.bookstore.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Collection;

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
    private int id_owner;
    @Column(columnDefinition = "varchar(500) default 'No description provided for this Book'")
    private String desciption;
    @Column(columnDefinition = "varchar(3000) default 'C:\timage\tpanda.jpg'")
    private String cover;
    private boolean archived;
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Category> categories;
//    @JsonIgnore
//    @OneToMany( mappedBy="book" )
//    private List<Resource> resources = new ArrayList<>();

    @OneToOne(mappedBy = "book")
    private ArchiveBook archiveBook;

    public Book() {
    }

    public Book(String isbn, String title, String author, float price,String cover, String desciption) {
        this.isbn = isbn;
        this.title = title;
        Author = author;
        this.price = price;
        this.cover = cover;
        this.desciption = desciption;
        archived=false;
    }
    
    

    public Book(String isbn, String title, String author, float price) {
		this.isbn = isbn;
		this.title = title;
		Author = author;
		this.price = price;
	}

	public Book(String isbn, String title, String author, float price, int id_owner, String cover, String desciption, Collection<Category> categories) {
        this.isbn = isbn;
        this.title = title;
        Author = author;
        this.price = price;
        this.id_owner = id_owner;
        this.cover = cover;
        this.desciption = desciption;
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

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getId_owner() {return id_owner;}

    public void setId_owner(int id_owner) {this.id_owner = id_owner;}

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