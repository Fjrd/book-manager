package com.example.bookmanager.controller;

import com.example.bookmanager.mapper.GenericMapper;
import com.example.bookmanager.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class GenericRestController<Model, ModelDto> {

    private final GenericService<Model> service;
    private final GenericMapper<Model, ModelDto> mapper;

    @GetMapping()
    public @ResponseBody List<ModelDto> getAll(){
        List<Model> models = service.findAll();
        return models.stream()
                .map(model -> mapper.modelToDto(model))
                .collect(Collectors.toList());
    }

    @PostMapping
    public @ResponseBody Map<String, Object> create(@RequestBody @Valid ModelDto json) {
        Model created = service.save(mapper.dtoToModel(json));

        Map<String, Object> m = new HashMap<>();
        m.put("success", true);
        m.put("created", created);
        return m;
    }

    @GetMapping("{id}")
    public @ResponseBody
    ModelDto getOne(@PathVariable UUID id) {
        return mapper.modelToDto(service.findById(id));
    }

    @PutMapping("{id}")
    public @ResponseBody Map<String, Object> update(@PathVariable UUID id, @RequestBody @Valid ModelDto json) {

        Map<String, Object> m = new HashMap<>();

        try{
            Model entity = service.update(id, mapper.dtoToModel(json));
            m.put("success", true);
            m.put("id", id);
            m.put("updated", mapper.modelToDto(entity));
            return m;
        }
        catch (ResourceNotFoundException ex){
            m.put("success", false);
            m.put("id", id);
            return m;
        }
    }

    @DeleteMapping("{id}")
    public @ResponseBody Map<String, Object> deleteById(@PathVariable UUID id){

        Map<String, Object> m = new HashMap<>();

        try{
            service.deleteById(id);
            m.put("success", true);
            m.put("id", id);
            return m;
        }
        catch (ResourceNotFoundException ex){
            m.put("success", false);
            m.put("id", id);
            return m;
        }
    }
}
