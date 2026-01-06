package com.example.distribuida.Servicelmpl;

import com.example.distribuida.repository.FacturaDetalleRepository;
import com.example.distribuida.model.FacturaDetalle;
import com.example.distribuida.Servicelmpl.FacturaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

    @Autowired
    private FacturaDetalleRepository repository;

    @Override
    public List<FacturaDetalle> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<FacturaDetalle> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public FacturaDetalle save(FacturaDetalle detalle) {
        return repository.save(detalle);
    }

    @Override
    public FacturaDetalle update(Integer id, FacturaDetalle detalle) {
        FacturaDetalle fd = repository.findById(id).orElse(null);
        if (fd == null) return null;

        fd.setCantidad(detalle.getCantidad());
        fd.setSubtotal(detalle.getSubtotal());
        fd.setIdFactura(detalle.getIdFactura());
        fd.setIdLibro(detalle.getIdLibro());

        return repository.save(fd);
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) repository.deleteById(id);
    }
}
