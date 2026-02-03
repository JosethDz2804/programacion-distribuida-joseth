package com.example.distribuida.service;

import com.example.distribuida.Servicelmpl.FacturaDetalleServiceImpl;
import com.example.distribuida.model.FacturaDetalle;
import com.example.distribuida.repository.FacturaDetalleRepository;
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
public class FacturaDetalleServiceTestUnitaria {

    @Mock
    private FacturaDetalleRepository facturaDetalleRepository;

    @InjectMocks
    private FacturaDetalleServiceImpl facturaDetalleService;

    @Test
    void testFindAll() {
        when(facturaDetalleRepository.findAll()).thenReturn(List.of(new FacturaDetalle()));

        List<FacturaDetalle> lista = facturaDetalleService.findAll();

        assertEquals(1, lista.size());
    }

    @Test
    void testFindById() {
        FacturaDetalle detalle = new FacturaDetalle();
        detalle.setIdFacturaDetalle(1);

        when(facturaDetalleRepository.findById(1)).thenReturn(Optional.of(detalle));

        Optional<FacturaDetalle> resultado = facturaDetalleService.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getIdFacturaDetalle());
    }

    @Test
    void testSave() {
        FacturaDetalle detalle = new FacturaDetalle();
        when(facturaDetalleRepository.save(detalle)).thenReturn(detalle);

        FacturaDetalle guardado = facturaDetalleService.save(detalle);

        assertNotNull(guardado);
    }

    @Test
    void testDelete() {
        when(facturaDetalleRepository.existsById(1)).thenReturn(true);

        facturaDetalleService.delete(1);

        verify(facturaDetalleRepository).deleteById(1);
    }
}
