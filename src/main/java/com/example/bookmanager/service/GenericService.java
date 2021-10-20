package com.example.bookmanager.service;

import java.util.List;
import java.util.UUID;

public interface GenericService<T> {
    List<T> findAll();
    T save(T entity);
    T findById(UUID id);
    void delete(T entity);
    void deleteById(UUID id);
    T update(UUID id, T entity);
}
