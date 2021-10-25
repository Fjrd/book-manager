package com.example.bookmanager.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenericService<T> {
    List<T> findAll();
    T save(T entity);
    Optional<T> findById(UUID id);
    boolean deleteById(UUID id);
    Optional<T> update(UUID id, T entity);
}
