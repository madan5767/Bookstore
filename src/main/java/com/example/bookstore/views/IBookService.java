package com.example.bookstore.views;


import com.example.bookstore.models.ArchiveBook;
import com.example.bookstore.models.Book;

import java.util.List;

public interface IBookService {

    List<Book> retrieveAllBooks();
    Book addBook(Book book);
    ArchiveBook archiveBook(String id);
    Book updateBook(Book book);
    Book retrieveBookById(String id);
    List<Book> retrieveBookByTitle(String name);
    List<ArchiveBook> retrieveArchivedBooks();
}
