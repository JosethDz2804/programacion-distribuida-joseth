package com.example.distribuida.service;

import com.example.distribuida.Servicelmpl.LibroServiceImpl;
import com.example.distribuida.model.Libro;
import com.example.distribuida.repository.LibroRepository;
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
public class LibroServiceTestUnitaria {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServiceImpl libroService;

    @Test
    void testFindAll() {
        when(libroRepository.findAll()).thenReturn(List.of(new Libro()));

        List<Libro> lista = libroService.findAll();

        assertEquals(1, lista.size());
    }

    @Test
    void testFindById() {
        Libro libro = new Libro();
        libro.setIdLibro(1);

        when(libroRepository.findById(1)).thenReturn(Optional.of(libro));

        Optional<Libro> resultado = libroService.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getIdLibro());
    }

    @Test
    void testSave() {
        Libro libro = new Libro();
        when(libroRepository.save(libro)).thenReturn(libro);

        Libro guardado = libroService.save(libro);

        assertNotNull(guardado);
    }

    @Test
    void testDelete() {
        when(libroRepository.existsById(1)).thenReturn(true);

        libroService.delete(1);

        verify(libroRepository).deleteById(1);
    }
}
