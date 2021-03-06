package com.example.bookstore.views;


import com.example.bookstore.models.ArchiveBook;
import com.example.bookstore.models.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IBookService {

    List<Book> retrieveAllBooks();
    Book addBook(Book book, MultipartFile file) throws IOException;
    ArchiveBook archiveBook(String id);
    Book updateBook(Book book);
    Book retrieveBookById(String id);
    List<Book> retrieveBookByTitle(String name);
    List<ArchiveBook> retrieveArchivedBooks();
}
