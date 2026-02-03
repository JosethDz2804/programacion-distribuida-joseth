package com.example.distribuida.controller;

import com.example.distribuida.Servicelmpl.FacturaService;
import com.example.distribuida.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Factura>> findAll(){
        List<Factura> facturas = facturaService.findAll();
        return ResponseEntity.ok(facturas);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> findOne(@PathVariable int id){
        Optional<Factura> factura = facturaService.findById(id);
        if (factura.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(factura.get());
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Factura> save(@RequestBody Factura factura){
        Factura facturaNueva = facturaService.save(factura);
        return ResponseEntity.ok(facturaNueva);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Factura> update(@PathVariable int id, @RequestBody Factura factura){
        Factura facturaActualizada = facturaService.update(id,factura);
        if (facturaActualizada == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaActualizada);
    }

    //ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        facturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
