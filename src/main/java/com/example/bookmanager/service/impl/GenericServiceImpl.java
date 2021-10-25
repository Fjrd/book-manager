package com.example.bookmanager.service.impl;

import com.example.bookmanager.domain.BaseEntity;
import com.example.bookmanager.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {

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
    public Optional<T> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteById(UUID id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        else return false;
    }

    @Override
    public Optional<T> update(UUID id, T entity) {
        if(repository.existsById(id)){
            entity.setId(id);
            repository.save(entity);
            return repository.findById(id);
        }
        else {
            return Optional.empty();
        }
    }

}