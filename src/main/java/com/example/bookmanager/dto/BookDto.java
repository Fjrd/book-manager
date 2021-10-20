package com.example.bookmanager.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {

    String isbn;
    String title;
    String description;
    String author;
}
