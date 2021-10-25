package com.example.bookmanager.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewDto implements Serializable {

    private String body;
    private Integer grade;
    private String bookIsbn;
}
