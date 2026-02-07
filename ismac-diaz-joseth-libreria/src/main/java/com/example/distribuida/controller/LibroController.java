package com.example.distribuida.controller;

import com.example.distribuida.Servicelmpl.LibroService;
import com.example.distribuida.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Libro>> findAll(){
        List<Libro> libros = libroService.findAll();
        return ResponseEntity.ok(libros);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> findOne(@PathVariable int id){
        Optional<Libro> libro = libroService.findById(id);
        if (libro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro.get());
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Libro> save(@RequestBody Libro libro){
        Libro libroNuevo = libroService.save(libro);
        return ResponseEntity.ok(libroNuevo);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@PathVariable int id, @RequestBody Libro libro){
        Libro libroActualizado = libroService.update(id,libro);
        if (libroActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libroActualizado);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
