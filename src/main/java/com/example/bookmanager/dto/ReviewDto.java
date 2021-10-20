package com.example.bookmanager.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewDto implements Serializable {

    String body;
    Integer grade;
    String bookIsbn;
}
