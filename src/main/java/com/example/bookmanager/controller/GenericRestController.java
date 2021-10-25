package com.example.bookmanager.controller;

import com.example.bookmanager.domain.BaseEntity;
import com.example.bookmanager.mapper.GenericMapper;
import com.example.bookmanager.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class GenericRestController<Model extends BaseEntity, ModelDto> {

    private final GenericService<Model> service;
    private final GenericMapper<Model, ModelDto> mapper;

    @GetMapping()
    public ResponseEntity<List<ModelDto>> getAll(){
        List<Model> models = service.findAll();
        List<ModelDto> dtos = models.stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<ModelDto> create(@RequestBody @Valid ModelDto json) {
        Model created = service.save(mapper.dtoToModel(json));
        ModelDto dto = mapper.modelToDto(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ModelDto> getById(@PathVariable UUID id) {
        Optional<Model> model = service.findById(id);
        return (model.isEmpty()) ?
                ResponseEntity.notFound().build():
                ResponseEntity.ok(mapper.modelToDto(model.get()));
    }

    @PutMapping("{id}")
    public ResponseEntity<ModelDto> update(@PathVariable UUID id, @RequestBody @Valid ModelDto json) {
        Optional<Model> model = service.update(id, mapper.dtoToModel(json));
        return model.isEmpty()?
                ResponseEntity.notFound().build():
                ResponseEntity.ok(mapper.modelToDto(model.get()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable UUID id){
        boolean isDeleted = service.deleteById(id);
        return (isDeleted) ?
                ResponseEntity.ok(HttpStatus.OK):
                ResponseEntity.notFound().build();

    }
}
