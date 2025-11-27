package com.example.distribuida.controller;

import com.example.distribuida.model.Autor;
import com.example.distribuida.service.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> findAll() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Autor findById(@PathVariable Integer id) {
        return autorService.findById(id);
    }

    @PostMapping
    public Autor create(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @PutMapping("/{id}")
    public Autor update(@PathVariable Integer id, @RequestBody Autor autor) {
        autor.setIdAutor(id); // ← ESTE ES EL CORRECTO
        return autorService.save(autor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        autorService.delete(id);
    }
}
