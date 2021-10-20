package com.example.bookmanager.mapper;

import com.example.bookmanager.domain.Review;
import com.example.bookmanager.dto.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends GenericMapper<Review, ReviewDto> {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);
}
