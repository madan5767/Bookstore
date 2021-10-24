package com.example.bookstore.models;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
public class ArchiveBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long archiveId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Book book;
    private Date deletionDate;

    public ArchiveBook(Book book) {
        this.book= book;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.deletionDate = date;
        formatter.format(this.deletionDate);
    }
}