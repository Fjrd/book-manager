package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
