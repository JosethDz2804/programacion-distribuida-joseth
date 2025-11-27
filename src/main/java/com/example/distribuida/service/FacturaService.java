package com.example.distribuida.service;

import com.example.distribuida.model.Factura;
import com.example.distribuida.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    public Factura findById(Integer id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    public void delete(Integer id) {
        facturaRepository.deleteById(id);
    }
}
