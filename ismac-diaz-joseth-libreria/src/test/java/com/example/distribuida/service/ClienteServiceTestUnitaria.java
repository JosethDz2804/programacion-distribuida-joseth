package com.example.distribuida.service;

import com.example.distribuida.Servicelmpl.ClienteServiceImpl;
import com.example.distribuida.model.Cliente;
import com.example.distribuida.repository.ClienteRepository;
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
public class ClienteServiceTestUnitaria {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void testFindAll() {
        when(clienteRepository.findAll()).thenReturn(List.of(new Cliente()));
        List<Cliente> lista = clienteService.findAll();
        assertEquals(1, lista.size());
    }

    @Test
    void testFindById() {
        Cliente c = new Cliente();
        c.setIdCliente(1);
        when(clienteRepository.findById(1)).thenReturn(Optional.of(c));

        Optional<Cliente> resultado = clienteService.findById(1);
        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getIdCliente());
    }

    @Test
    void testSave() {
        Cliente c = new Cliente();
        when(clienteRepository.save(c)).thenReturn(c);

        Cliente guardado = clienteService.save(c);
        assertNotNull(guardado);
    }

    @Test
    void testDelete() {
        when(clienteRepository.existsById(1)).thenReturn(true);
        clienteService.delete(1);
        verify(clienteRepository).deleteById(1);
    }
}
