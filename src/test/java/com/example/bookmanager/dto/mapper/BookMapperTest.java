package com.example.bookmanager.dto.mapper;


import com.example.bookmanager.domain.Book;
import com.example.bookmanager.dto.BookDto;
import com.example.bookmanager.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class BookMapperTest {

    BookMapper mapper;

    @Test
    public void shouldMapBookToDto(){
        Book book1 = Book.builder()
                .isbn("124")
                .title("Spring 5 Design Patterns")
                .description("Learn various design patterns and best practices in Spring 5 and use them to solve common design problems")
                .author("Dinesh Rajput")
                .build();
        System.out.println(book1.toString());

        BookDto dto = mapper.modelToDto(book1);

        System.out.println(dto.toString());

        assertThat(dto)
                .isNotNull()
                .matches(bookDto -> bookDto.getIsbn().equals(book1.getIsbn()))
                .matches(bookDto -> bookDto.getAuthor().equals(book1.getAuthor()))
                .matches(bookDto -> bookDto.getTitle().equals(book1.getTitle()))
                .matches(bookDto -> bookDto.getDescription().equals(book1.getDescription()));

    }

}