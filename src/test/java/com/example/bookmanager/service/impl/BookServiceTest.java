package com.example.bookmanager.service.impl;

import com.example.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class BookServiceTest {

    @Mock
    BookRepository repository;

}