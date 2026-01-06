package com.example.distribuida.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacturaDetalleTestUnitario {

    @Test
    public void testFacturaDetalleConstructor() {
        FacturaDetalle detalle = new FacturaDetalle();
        assertNotNull(detalle);
    }

    @Test
    public void testSettersAndGetters() {
        FacturaDetalle detalle = new FacturaDetalle();

        detalle.setIdFacturaDetalle(100);
        detalle.setCantidad(3);
        detalle.setSubtotal(45.0);
        detalle.setIdFactura(5);
        detalle.setIdLibro(20);

        assertEquals(100, detalle.getIdFacturaDetalle());
        assertEquals(3, detalle.getCantidad());
        assertEquals(45.0, detalle.getSubtotal());
        assertEquals(5, detalle.getIdFactura());
        assertEquals(20, detalle.getIdLibro());
    }
}
