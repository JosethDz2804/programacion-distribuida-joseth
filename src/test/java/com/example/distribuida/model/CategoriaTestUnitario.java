package com.example.distribuida.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTestUnitario {

    @Test
    public void testCategoriaConstructor() {
        Categoria categoria = new Categoria();
        assertNotNull(categoria);
    }

    @Test
    public void testSettersAndGetters() {
        Categoria categoria = new Categoria();

        categoria.setIdCategoria(10);
        categoria.setCategoria("Novela");
        categoria.setDescripcion("Libros narrativos");

        assertEquals(10, categoria.getIdCategoria());
        assertEquals("Novela", categoria.getCategoria());
        assertEquals("Libros narrativos", categoria.getDescripcion());
    }
}
