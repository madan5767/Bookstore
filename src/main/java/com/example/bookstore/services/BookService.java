package com.example.bookstore.services;


import com.example.bookstore.dao.ArchiveBookRepository;
import com.example.bookstore.dao.BookRepository;
import com.example.bookstore.models.ArchiveBook;
import com.example.bookstore.models.Book;
import com.example.bookstore.views.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ArchiveBookRepository archive_bookRepository;

    private final Logger logger = LoggerFactory.getLogger(BookService.class);


    @Override
    public List<Book> retrieveAllBooks() {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(books::add);
        logger.info("retrieved list of books: " + books);
        return books;
    }

//    @Override
//    public Book addBook(Book book) {
//    bookRepository.save(book);
//         return book;
//    }
    @Override
    public Book addBook(Book book, MultipartFile file) throws IOException {

        File saveFile = new ClassPathResource("static/bookimg").getFile();
        Path path = Paths.get(saveFile.getAbsolutePath() + File.separator+file.getOriginalFilename());

        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        book.setCover(file.getOriginalFilename());
        Book savedBook = bookRepository.save(book);
        savedBook.setCover(ServletUriComponentsBuilder.fromCurrentContextPath().path("/bookimg/").path(savedBook.getCover()).toUriString());
        return savedBook;
    }

    @Override
    public ArchiveBook archiveBook(String id) {
        Book book = retrieveBookById(id);
        book.setArchived(true);
        bookRepository.save(book);
       return archive_bookRepository.save(new ArchiveBook(book));
    }

    @Override
    public Book updateBook(Book b) {
        Book book= this.retrieveBookById(b.getIsbn());
        return bookRepository.save(b);
    }

    @Override
    public Book retrieveBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.get() == null)
            logger.error("Couldn't find book with id :" + id);
        else logger.info("Retrieved book " + book.get());
        return book.get();
    }

    @Override
    public List<Book> retrieveBookByTitle(String title) {
        return this.retrieveAllBooks()
                .stream()
                .filter(b->b.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArchiveBook> retrieveArchivedBooks()
    {
        List<ArchiveBook> books = new ArrayList<ArchiveBook>();

         archive_bookRepository.findAll().forEach(books::add);
         return books;
    }

}
