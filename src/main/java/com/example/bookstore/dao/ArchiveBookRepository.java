package com.example.bookstore.dao;


import com.example.bookstore.models.ArchiveBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveBookRepository extends JpaRepository<ArchiveBook, Long> {
}