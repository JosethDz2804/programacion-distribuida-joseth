package com.example.distribuida.controller;

import com.example.distribuida.model.FacturaDetalle;
import com.example.distribuida.service.FacturaDetalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles")
public class FacturaDetalleController {

    private final FacturaDetalleService service;

    public FacturaDetalleController(FacturaDetalleService service) {
        this.service = service;
    }

    @GetMapping
    public List<FacturaDetalle> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FacturaDetalle findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public FacturaDetalle create(@RequestBody FacturaDetalle detalle) {
        return service.save(detalle);
    }

    @PutMapping("/{id}")
    public FacturaDetalle update(@PathVariable Integer id, @RequestBody FacturaDetalle detalle) {
        detalle.setIdFacturaDetalle(id);
        return service.save(detalle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
