package com.example.bookmanager.mapper;

public interface GenericMapper<Model, Dto> {
    Dto modelToDto(Model model);
    Model dtoToModel(Dto dto);
}
