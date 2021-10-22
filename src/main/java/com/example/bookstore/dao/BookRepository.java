package com.example.bookstore.dao;

import com.example.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {

    @Query(value = "SELECT b FROM Book b WHERE b.isbn like %:isbn%")
	Book findByIsbn(@Param("isbn") String isbn);

}
