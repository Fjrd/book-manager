package com.example.bookmanager.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDto implements Serializable {

    private String isbn;
    private String title;
    private String description;
    private String author;
}
