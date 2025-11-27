package com.example.distribuida.repository;

import com.example.distribuida.model.Categoria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("classpath:application.properties")
public class CategoriaRepositoryTestIntegracion {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    @Commit
    public void testCrearCategoria() {
        Categoria c = new Categoria();
        c.setCategoria("Terror");
        c.setDescripcion("Historias de miedo");

        Categoria guardado = categoriaRepository.save(c);
        assertNotNull(guardado.getIdCategoria());
    }

    @Test
    @Commit
    public void testEditarCategoria() {
        Categoria c = new Categoria();
        c.setCategoria("Fantasia");
        c.setDescripcion("Magia y mundos imaginarios");
        categoriaRepository.save(c);

        c.setDescripcion("Mundos mágicos y épicos");
        Categoria actualizado = categoriaRepository.save(c);

        assertEquals("Mundos mágicos y épicos", actualizado.getDescripcion());
    }

    @Test
    @Commit
    public void testEliminarCategoria() {
        Categoria c = new Categoria();
        c.setCategoria("Comedia");
        c.setDescripcion("Libros graciosos");

        Categoria guardado = categoriaRepository.save(c);
        categoriaRepository.delete(guardado);

        Optional<Categoria> result = categoriaRepository.findById(guardado.getIdCategoria());
        assertTrue(result.isEmpty());
    }
}
