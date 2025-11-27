package com.example.distribuida.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibroTestUnitario {

    @Test
    public void testLibroConstructor() {
        Libro libro = new Libro();
        assertNotNull(libro);
    }

    @Test
    public void testSettersAndGetters() {
        Libro libro = new Libro();

        libro.setIdLibro(1);
        libro.setTitulo("Cien años de soledad");
        libro.setEditorial("Sudamericana");
        libro.setNumPaginas(350);
        libro.setEdicion("Primera");
        libro.setIdioma("Español");
        libro.setFechaPublicacion("1967-05-30");
        libro.setDescripcion("Novela clásica");
        libro.setTipoPasta("Dura");
        libro.setIsbn("9780307474728");
        libro.setNumEjemplares(10);
        libro.setPortada("portada.jpg");
        libro.setPresentacion("Tapa dura");
        libro.setPrecio(25.50);
        libro.setIdCategoria(3);
        libro.setIdAutor(1);

        assertEquals(1, libro.getIdLibro());
        assertEquals("Cien años de soledad", libro.getTitulo());
        assertEquals("Sudamericana", libro.getEditorial());
        assertEquals(350, libro.getNumPaginas());
        assertEquals("Primera", libro.getEdicion());
        assertEquals("Español", libro.getIdioma());
        assertEquals("1967-05-30", libro.getFechaPublicacion());
        assertEquals("Novela clásica", libro.getDescripcion());
        assertEquals("Dura", libro.getTipoPasta());
        assertEquals("9780307474728", libro.getIsbn());
        assertEquals(10, libro.getNumEjemplares());
        assertEquals("portada.jpg", libro.getPortada());
        assertEquals("Tapa dura", libro.getPresentacion());
        assertEquals(25.50, libro.getPrecio());
        assertEquals(3, libro.getIdCategoria());
        assertEquals(1, libro.getIdAutor());
    }
}
