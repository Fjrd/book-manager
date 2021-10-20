package com.example.bookmanager.mapper;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper extends GenericMapper<Book, BookDto>{
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
}
