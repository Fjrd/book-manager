package com.example.bookmanager.controller;

import com.example.bookmanager.domain.Review;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reviews")
public class ReviewController extends GenericRestController<Review>{
}
