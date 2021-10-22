package com.example.bookstore.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class ArchiveBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Book book;


    private Date deletion_date;

    public ArchiveBook() {
    }

    public ArchiveBook(Book book) {
        this.book= book;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.deletion_date = date;
        formatter.format(this.deletion_date);
    }

    public Long getId() {
        return id;
    }


    public Date getDeletion_date() {
        return deletion_date;
    }

    public void setDeletion_date(Date deletion_date) {
        this.deletion_date = deletion_date;
    }
}