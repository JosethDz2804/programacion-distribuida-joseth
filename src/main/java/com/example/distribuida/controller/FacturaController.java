package com.example.distribuida.controller;

import com.example.distribuida.model.Factura;
import com.example.distribuida.service.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Factura> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Factura findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Factura create(@RequestBody Factura factura) {
        return service.save(factura);
    }

    @PutMapping("/{id}")
    public Factura update(@PathVariable Integer id, @RequestBody Factura factura) {
        factura.setIdFactura(id);
        return service.save(factura);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
