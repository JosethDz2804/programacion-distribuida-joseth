package com.example.distribuida.repository;

import com.example.distribuida.model.Libro;
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
public class LibroRepositoryTestIntegracion {

    @Autowired
    private LibroRepository libroRepository;

    @Test
    @Commit
    public void testCrearLibro() {
        Libro l = new Libro();
        l.setTitulo("El Principito");
        l.setEditorial("ReyNaran");
        l.setNumPaginas(120);
        l.setEdicion("3ra");
        l.setIdioma("Español");
        l.setFechaPublicacion("1950-03-15");
        l.setDescripcion("Un clásico");
        l.setTipoPasta("Dura");
        l.setIsbn("1234567890");
        l.setNumEjemplares(10);
        l.setPortada("portada.png");
        l.setPresentacion("Bonita");
        l.setPrecio(15.50);
        l.setIdCategoria(1);
        l.setIdAutor(1);

        Libro guardado = libroRepository.save(l);
        assertNotNull(guardado.getIdLibro());
    }

    @Test
    @Commit
    public void testEditarLibro() {
        Libro l = new Libro();
        l.setTitulo("Harry Potter");
        l.setEditorial("Bloomsbury");
        l.setNumPaginas(320);
        l.setEdicion("1ra");
        l.setIdioma("Inglés");
        l.setFechaPublicacion("1997-06-26");
        l.setDescripcion("Magia");
        l.setTipoPasta("Blanda");
        l.setIsbn("99999999");
        l.setNumEjemplares(50);
        l.setPortada("hp.png");
        l.setPresentacion("Normal");
        l.setPrecio(20.00);
        l.setIdCategoria(1);
        l.setIdAutor(1);

        libroRepository.save(l);

        l.setPrecio(25.00);
        Libro actualizado = libroRepository.save(l);

        assertEquals(25.00, actualizado.getPrecio());
    }

    @Test
    @Commit
    public void testEliminarLibro() {
        Libro l = new Libro();
        l.setTitulo("Test Libro");
        l.setEditorial("Test");
        l.setNumPaginas(100);
        l.setEdicion("x");
        l.setIdioma("x");
        l.setFechaPublicacion("2020-01-01");
        l.setDescripcion("x");
        l.setTipoPasta("x");
        l.setIsbn("123");
        l.setNumEjemplares(1);
        l.setPortada("x");
        l.setPresentacion("x");
        l.setPrecio(1.0);
        l.setIdCategoria(1);
        l.setIdAutor(1);

        Libro guardado = libroRepository.save(l);
        libroRepository.delete(guardado);

        Optional<Libro> result = libroRepository.findById(guardado.getIdLibro());
        assertTrue(result.isEmpty());
    }
}
