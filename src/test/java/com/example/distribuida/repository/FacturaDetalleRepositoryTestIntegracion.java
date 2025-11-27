package com.example.distribuida.repository;

import com.example.distribuida.model.FacturaDetalle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class FacturaDetalleRepositoryTestIntegracion {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Test
    @Commit
    public void testCrearFacturaDetalle() {
        FacturaDetalle detalle = new FacturaDetalle();
        detalle.setCantidad(2);
        detalle.setSubtotal(50.0);
        detalle.setIdFactura(1); // Debe existir factura
        detalle.setIdLibro(1);   // Debe existir libro

        FacturaDetalle guardada = facturaDetalleRepository.save(detalle);

        assertNotNull(guardada.getIdFacturaDetalle());
    }

    @Test
    @Commit
    public void testModificarFacturaDetalle() {
        FacturaDetalle detalle = new FacturaDetalle();
        detalle.setCantidad(1);
        detalle.setSubtotal(20.0);
        detalle.setIdFactura(1);
        detalle.setIdLibro(1);

        FacturaDetalle guardado = facturaDetalleRepository.save(detalle);

        guardado.setCantidad(3);
        facturaDetalleRepository.save(guardado);

        Optional<FacturaDetalle> buscado =
                facturaDetalleRepository.findById(guardado.getIdFacturaDetalle());

        assertTrue(buscado.isPresent());
        assertEquals(3, buscado.get().getCantidad());
    }

    @Test
    @Commit
    public void testEliminarFacturaDetalle() {
        FacturaDetalle detalle = new FacturaDetalle();
        detalle.setCantidad(4);
        detalle.setSubtotal(80.0);
        detalle.setIdFactura(1);
        detalle.setIdLibro(1);

        FacturaDetalle guardado = facturaDetalleRepository.save(detalle);

        facturaDetalleRepository.deleteById(guardado.getIdFacturaDetalle());

        assertFalse(facturaDetalleRepository.findById(guardado.getIdFacturaDetalle()).isPresent());
    }
}
