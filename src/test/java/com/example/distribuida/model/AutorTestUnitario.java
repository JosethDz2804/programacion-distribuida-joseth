package com.example.distribuida.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTestUnitario {

    @Test
    public void testAutorConstructor() {
        Autor autor = new Autor();
        assertNotNull(autor);
    }

    @Test
    public void testSettersAndGetters() {
        Autor autor = new Autor();

        autor.setIdAutor(1);
        autor.setNombre("Gabriel");
        autor.setApellido("García");
        autor.setPais("Colombia");
        autor.setDireccion("Calle 123");
        autor.setTelefono("0987654321");
        autor.setCorreo("autor@gmail.com");

        assertEquals(1, autor.getIdAutor());
        assertEquals("Gabriel", autor.getNombre());
        assertEquals("García", autor.getApellido());
        assertEquals("Colombia", autor.getPais());
        assertEquals("Calle 123", autor.getDireccion());
        assertEquals("0987654321", autor.getTelefono());
        assertEquals("autor@gmail.com", autor.getCorreo());
    }
}
