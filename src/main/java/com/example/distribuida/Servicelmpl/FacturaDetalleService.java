package com.example.distribuida.Servicelmpl;

import com.example.distribuida.model.FacturaDetalle;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleService {

    List<FacturaDetalle> findAll();
    Optional<FacturaDetalle> findById(Integer id);
    FacturaDetalle save(FacturaDetalle detalle);
    FacturaDetalle update(Integer id, FacturaDetalle detalle);
    void delete(Integer id);
}