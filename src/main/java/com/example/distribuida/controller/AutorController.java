package com.example.distribuida.controller;

import com.example.distribuida.Servicelmpl.AutorService;
import com.example.distribuida.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        List<Autor> autor = autorService.findAll();
        return ResponseEntity.ok(autor);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public  ResponseEntity<Autor> findOne(@PathVariable int id){
        Optional<Autor> autor = autorService.findById(id);
        if (autor == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor.orElse(null));
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Autor> save(@RequestBody Autor autor){
        Autor autorNuevo = autorService.save(autor);
        return ResponseEntity.ok(autorNuevo);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Autor> update(@PathVariable int id, @RequestBody Autor autor){
        Autor autorActualizado = autorService.update(id, autor);
        if (autorActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autorActualizado);
    }

    //ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
