package com.example.distribuida.controller;

import com.example.distribuida.model.Libro;
import com.example.distribuida.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libro> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Libro findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Libro create(@RequestBody Libro libro) {
        return service.save(libro);
    }

    @PutMapping("/{id}")
    public Libro update(@PathVariable Integer id, @RequestBody Libro libro) {
        libro.setIdLibro(id);
        return service.save(libro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
