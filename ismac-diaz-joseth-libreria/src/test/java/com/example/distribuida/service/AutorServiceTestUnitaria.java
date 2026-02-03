package com.example.distribuida.service;

import com.example.distribuida.Servicelmpl.AutorServiceImpl;
import com.example.distribuida.model.Autor;
import com.example.distribuida.repository.AutorRepository;
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
public class AutorServiceTestUnitaria {

    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private AutorServiceImpl autorService;

    @Test
    void testFindAll() {
        when(autorRepository.findAll()).thenReturn(List.of(new Autor()));

        List<Autor> lista = autorService.findAll();

        assertEquals(1, lista.size());
    }

    @Test
    void testFindById() {
        Autor autor = new Autor();
        autor.setIdAutor(1);

        when(autorRepository.findById(1)).thenReturn(Optional.of(autor));

        Optional<Autor> resultado = autorService.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getIdAutor());
    }

    @Test
    void testSave() {
        Autor autor = new Autor();
        when(autorRepository.save(autor)).thenReturn(autor);

        Autor guardado = autorService.save(autor);

        assertNotNull(guardado);
    }

    @Test
    void testDelete() {
        when(autorRepository.existsById(1)).thenReturn(true);

        autorService.delete(1);

        verify(autorRepository).deleteById(1);
    }
}
