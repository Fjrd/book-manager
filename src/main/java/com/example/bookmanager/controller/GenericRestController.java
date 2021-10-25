package com.example.bookmanager.controller;

import com.example.bookmanager.mapper.GenericMapper;
import com.example.bookmanager.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class GenericRestController<Model, ModelDto> {

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
        return ResponseEntity.ok(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ModelDto> getOne(@PathVariable UUID id) {
        Model model = service.findById(id);
        ModelDto dto = mapper.modelToDto(model);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ModelDto> update(@PathVariable UUID id, @RequestBody @Valid ModelDto json) {
        Model updated = service.update(id, mapper.dtoToModel(json));
        ModelDto dto = mapper.modelToDto(updated);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable UUID id){
        service.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
