 package com.example.bookstore.controllers;

import com.example.bookstore.models.ArchiveBook;
import com.example.bookstore.models.Book;
import com.example.bookstore.views.IBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

 @RestController
 @RequestMapping(path = "/book")
 public class BookController  {

      @Autowired
      IBookService bookService;

     @GetMapping("/getAll")
      public ResponseEntity<Collection<Book>> retrieveAllBooks() {
         Collection<Book> books =bookService.retrieveAllBooks();
         return ResponseEntity.ok(books);
      }


//     @PostMapping("/newBook")
//     public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) throws URISyntaxException {
//         Book result = bookService.addBook(book);
//         return ResponseEntity.created(new URI("/newBook" + result.getIsbn())).body(result);
//     }

     @PostMapping(value = "/newBook", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     public Book addBook(@RequestParam("book") String book, @RequestParam("file") MultipartFile file) throws IOException {
         Book saveBook = new ObjectMapper().readValue(book, Book.class);
         return bookService.addBook(saveBook, file);
     }


     @PostMapping("/ArchiveBook/{id}")
     public ResponseEntity<ArchiveBook> archiveBook(@Valid @PathVariable(name="id") String id) throws URISyntaxException {
              ArchiveBook result= bookService.archiveBook(id);
              return ResponseEntity.created(new URI("/archivedBook" + result.getArchiveId())).body(result);
          }


     @PutMapping(value="/updateBook" ,produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Book> updateBook(@Valid @RequestBody Book b) {
        Book book =bookService.updateBook(b);
         return ResponseEntity.ok(book);
     }

     @GetMapping("/getByID/{id}")
     public ResponseEntity<Book> retrieveBookById(@PathVariable(name="id") String id) {
         Book book  =bookService.retrieveBookById(id);
         return ResponseEntity.ok(book);
     }
     @GetMapping("/getBytitle/{title}")
     public ResponseEntity <Collection<Book>> retrieveBookBytitle(@PathVariable(name="title") String title) {
               return ResponseEntity.ok(bookService.retrieveBookByTitle(title));
     }
      @GetMapping("/retrieveArchivedBook")
      public ResponseEntity<?> retrieveArchivedBook() {
          List<ArchiveBook> books  =bookService.retrieveArchivedBooks();
          return ResponseEntity.ok(books);
      }

  }