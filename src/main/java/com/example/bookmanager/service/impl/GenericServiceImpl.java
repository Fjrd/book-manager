package com.example.bookmanager.service.impl;

import com.example.bookmanager.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;

public class GenericServiceImpl<T> implements GenericService<T> {

    @Autowired
    JpaRepository<T, UUID> repository = null;

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public T update(UUID id, T entity) {
        return repository.save(entity);
    }

}