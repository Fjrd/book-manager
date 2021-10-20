package com.example.bookmanager.controller;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.dto.BookDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books")
public class BookController extends GenericRestController<Book, BookDto> {
}
