package com.example.distribuida.service;

import com.example.distribuida.model.FacturaDetalle;
import com.example.distribuida.repository.FacturaDetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaDetalleService {

    private final FacturaDetalleRepository facturaDetalleRepository;

    public FacturaDetalleService(FacturaDetalleRepository facturaDetalleRepository) {
        this.facturaDetalleRepository = facturaDetalleRepository;
    }

    public List<FacturaDetalle> findAll() {
        return facturaDetalleRepository.findAll();
    }

    public FacturaDetalle findById(Integer id) {
        return facturaDetalleRepository.findById(id).orElse(null);
    }

    public FacturaDetalle save(FacturaDetalle detalle) {
        return facturaDetalleRepository.save(detalle);
    }

    public void delete(Integer id) {
        facturaDetalleRepository.deleteById(id);
    }
}
