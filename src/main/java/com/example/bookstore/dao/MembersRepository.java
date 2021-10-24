package com.example.bookstore.dao;

import com.example.bookstore.models.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long> {

}
