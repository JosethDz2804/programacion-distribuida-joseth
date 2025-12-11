package com.example.distribuida.Servicelmpl;

import com.example.distribuida.repository.FacturaRepository;
import com.example.distribuida.model.Factura;
import com.example.distribuida.Servicelmpl.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository repository;

    @Override
    public List<Factura> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Factura> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Factura save(Factura factura) {
        return repository.save(factura);
    }

    @Override
    public Factura update(Integer id, Factura factura) {
        Factura f = repository.findById(id).orElse(null);
        if (f == null) return null;

        f.setNumFactura(factura.getNumFactura());
        f.setFecha(factura.getFecha());
        f.setTotalNeto(factura.getTotalNeto());
        f.setIva(factura.getIva());
        f.setTotal(factura.getTotal());
        f.setIdCliente(factura.getIdCliente());

        return repository.save(f);
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) repository.deleteById(id);
    }
}
