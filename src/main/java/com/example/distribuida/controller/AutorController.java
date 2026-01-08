package com.example.distribuida.controller;

import com.example.distribuida.Servicelmpl.AutorService;
import com.example.distribuida.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        List<Autor> autor = autorService.findAll();
        return ResponseEntity.ok(autor);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Autor> findOne(@PathVariable int id){
        Optional<Autor> autor = autorService.findById(id);
        if (autor == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor.orElse(null));
    }

}
