package com.example.distribuida.service;

import com.example.distribuida.Servicelmpl.CategoriaServiceImpl;
import com.example.distribuida.model.Categoria;
import com.example.distribuida.repository.CategoriaRepository;
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
public class CategoriaServiceTestUnitaria {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Test
    void testFindAll() {
        when(categoriaRepository.findAll()).thenReturn(List.of(new Categoria()));

        List<Categoria> lista = categoriaService.findAll();

        assertEquals(1, lista.size());
    }

    @Test
    void testFindById() {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(1);

        when(categoriaRepository.findById(1)).thenReturn(Optional.of(categoria));

        Optional<Categoria> resultado = categoriaService.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getIdCategoria());
    }

    @Test
    void testSave() {
        Categoria categoria = new Categoria();
        when(categoriaRepository.save(categoria)).thenReturn(categoria);

        Categoria guardado = categoriaService.save(categoria);

        assertNotNull(guardado);
    }

    @Test
    void testDelete() {
        when(categoriaRepository.existsById(1)).thenReturn(true);

        categoriaService.delete(1);

        verify(categoriaRepository).deleteById(1);
    }
}
