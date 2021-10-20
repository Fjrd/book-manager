package com.example.bookmanager.mapper;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDto modelToDto(Book model);
    Book dtoToModel(BookDto dto);
}
