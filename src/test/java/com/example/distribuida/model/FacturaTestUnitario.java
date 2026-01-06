package com.example.distribuida.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacturaTestUnitario {

    @Test
    public void testFacturaConstructor() {
        Factura factura = new Factura();
        assertNotNull(factura);
    }

    @Test
    public void testSettersAndGetters() {
        Factura factura = new Factura();

        factura.setIdFactura(5);
        factura.setNumFactura("F001-123");
        factura.setFecha("2024-11-26");
        factura.setTotalNeto(50.0);
        factura.setIva(6.0);
        factura.setTotal(56.0);
        factura.setIdCliente(2);

        assertEquals(5, factura.getIdFactura());
        assertEquals("F001-123", factura.getNumFactura());
        assertEquals("2024-11-26", factura.getFecha());
        assertEquals(50.0, factura.getTotalNeto());
        assertEquals(6.0, factura.getIva());
        assertEquals(56.0, factura.getTotal());
        assertEquals(2, factura.getIdCliente());
    }
}
