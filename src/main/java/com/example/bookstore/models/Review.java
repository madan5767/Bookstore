package com.example.bookstore.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "review")
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String message;
    private Integer rating;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name="isbn")
    private Book book;

    public Review() {
        this.date = LocalDate.now();
    }
}
