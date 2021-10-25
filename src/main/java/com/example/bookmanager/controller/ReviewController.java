package com.example.bookmanager.controller;

import com.example.bookmanager.domain.Review;
import com.example.bookmanager.dto.ReviewDto;
import com.example.bookmanager.mapper.GenericMapper;
import com.example.bookmanager.service.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reviews")
public class ReviewController extends GenericRestController<Review, ReviewDto>{

    public ReviewController(ReviewService service, GenericMapper<Review, ReviewDto> mapper) {
        super(service, mapper);
    }
}
