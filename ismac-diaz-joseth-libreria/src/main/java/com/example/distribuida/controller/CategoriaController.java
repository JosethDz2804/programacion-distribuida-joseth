package com.example.distribuida.controller;

import com.example.distribuida.Servicelmpl.CategoriaService;
import com.example.distribuida.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categoria = categoriaService.findAll();
        return ResponseEntity.ok(categoria);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findOne(@PathVariable int id){
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria.orElse(null));
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        Categoria categoriaNueva = categoriaService.save(categoria);
        return ResponseEntity.ok(categoriaNueva);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable int id, @RequestBody Categoria categoria){
        Categoria categoriaActualizada = categoriaService.update(id, categoria);
        if (categoriaActualizada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaActualizada);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
