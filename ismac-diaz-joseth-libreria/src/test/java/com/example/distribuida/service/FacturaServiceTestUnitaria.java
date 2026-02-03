package com.example.distribuida.service;

import com.example.distribuida.Servicelmpl.FacturaServiceImpl;
import com.example.distribuida.model.Factura;
import com.example.distribuida.repository.FacturaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FacturaServiceTestUnitaria {

    @Mock
    private FacturaRepository facturaRepository;

    @InjectMocks
    private FacturaServiceImpl facturaService;

    @Test
    void testFindAll() {
        when(facturaRepository.findAll()).thenReturn(List.of(new Factura()));

        List<Factura> lista = facturaService.findAll();

        assertEquals(1, lista.size());
    }

    @Test
    void testFindById() {
        Factura factura = new Factura();
        factura.setIdFactura(1);

        when(facturaRepository.findById(1)).thenReturn(Optional.of(factura));

        Optional<Factura> resultado = facturaService.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getIdFactura());
    }

    @Test
    void testSave() {
        Factura factura = new Factura();
        when(facturaRepository.save(factura)).thenReturn(factura);

        Factura guardado = facturaService.save(factura);

        assertNotNull(guardado);
    }

    @Test
    void testDelete() {
        when(facturaRepository.existsById(1)).thenReturn(true);

        facturaService.delete(1);

        verify(facturaRepository).deleteById(1);
    }
}
