package com.example.distribuida.controller;

import com.example.distribuida.Servicelmpl.FacturaDetalleService;
import com.example.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/factura-detalles")
public class FacturaDetalleController {

    @Autowired
    private FacturaDetalleService facturaDetalleService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> findAll(){
        List<FacturaDetalle> detalle = facturaDetalleService.findAll();
        return ResponseEntity.ok(detalle);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalle> findOne(@PathVariable int id){
        Optional<FacturaDetalle> detalle = facturaDetalleService.findById(id);
        if (detalle.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalle.get());
    }

    // CREAR
    @PostMapping
    public ResponseEntity<FacturaDetalle> save(@RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle detalleNuevo = facturaDetalleService.save(facturaDetalle);
        return ResponseEntity.ok(detalleNuevo);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<FacturaDetalle> update(@PathVariable int id, @RequestBody FacturaDetalle facturaDetalle){
        FacturaDetalle actualizado = facturaDetalleService.update(id,facturaDetalle);
        if (actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        facturaDetalleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
