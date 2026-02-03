package com.example.distribuida.Servicelmpl;

import com.example.distribuida.model.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    List<Factura> findAll();
    Optional<Factura> findById(Integer id);
    Factura save(Factura factura);
    Factura update(Integer id, Factura factura);
    void delete(Integer id);
}
