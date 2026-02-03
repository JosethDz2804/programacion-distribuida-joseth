package com.example.distribuida.repository;

import com.example.distribuida.model.Factura;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class FacturaRepositoryTestIntegracion {

    @Autowired
    private FacturaRepository facturaRepository;

    @Test
    @Commit
    public void testCrearFactura() {
        Factura fact = new Factura();
        fact.setNumFactura("FAC-001");
        fact.setFecha("2024-11-27");
        fact.setTotalNeto(100.0);
        fact.setIva(12.0);
        fact.setTotal(112.0);
        fact.setIdCliente(1); // Debe existir en la BD

        Factura guardada = facturaRepository.save(fact);

        assertNotNull(guardada.getIdFactura());
    }

    @Test
    @Commit
    public void testModificarFactura() {
        Factura fact = new Factura();
        fact.setNumFactura("FAC-002");
        fact.setFecha("2024-11-28");
        fact.setTotalNeto(80.0);
        fact.setIva(9.6);
        fact.setTotal(89.6);
        fact.setIdCliente(1);

        Factura guardada = facturaRepository.save(fact);

        guardada.setTotalNeto(90.0);
        facturaRepository.save(guardada);

        Optional<Factura> buscada = facturaRepository.findById(guardada.getIdFactura());
        assertTrue(buscada.isPresent());
        assertEquals(90.0, buscada.get().getTotalNeto());
    }

    @Test
    @Commit
    public void testEliminarFactura() {
        Factura fact = new Factura();
        fact.setNumFactura("FAC-003");
        fact.setFecha("2024-11-28");
        fact.setTotalNeto(70.0);
        fact.setIva(8.4);
        fact.setTotal(78.4);
        fact.setIdCliente(1);

        Factura guardada = facturaRepository.save(fact);

        facturaRepository.deleteById(guardada.getIdFactura());

        assertFalse(facturaRepository.findById(guardada.getIdFactura()).isPresent());
    }
}
