package com.example.bookmanager.controller;

import com.example.bookmanager.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class GenericRestController<T> {

    @Autowired
    GenericService<T> service = null;


    @GetMapping()
    public @ResponseBody List<T> allUsers(){
        return service.findAll();
    }

    @PostMapping
    public @ResponseBody Map<String, Object> create(@RequestBody @Valid T json) {
        T created = service.save(json);

        Map<String, Object> m = new HashMap<>();
        m.put("success", true);
        m.put("created", created);
        return m;
    }

    @GetMapping("{id}")
    public @ResponseBody T get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public @ResponseBody Map<String, Object> update(@PathVariable UUID id, @RequestBody T json) {

        Map<String, Object> m = new HashMap<>();

        try{
            T entity = service.update(id, json);
            m.put("success", true);
            m.put("id", id);
            m.put("updated", entity);
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
