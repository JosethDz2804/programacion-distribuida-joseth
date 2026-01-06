package com.example.distribuida.repository;

import com.example.distribuida.model.Autor;
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
public class AutorRepositoryTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    @Commit
    public void testCrearAutor() {
        Autor a = new Autor();
        a.setNombre("Gabriel");
        a.setApellido("García Márquez");
        a.setPais("Colombia");
        a.setDireccion("Calle 123");
        a.setTelefono("0987654321");
        a.setCorreo("gabriel@gmail.com");

        Autor guardado = autorRepository.save(a);
        assertNotNull(guardado.getIdAutor());
    }

    @Test
    @Commit
    public void testEditarAutor() {
        Autor a = new Autor();
        a.setNombre("Julio");
        a.setApellido("Cortázar");
        a.setPais("Argentina");
        a.setDireccion("Buenos Aires");
        a.setTelefono("111");
        a.setCorreo("julio@gmail.com");

        autorRepository.save(a);

        a.setTelefono("222");
        Autor actualizado = autorRepository.save(a);

        assertEquals("222", actualizado.getTelefono());
    }

    @Test
    @Commit
    public void testEliminarAutor() {
        Autor a = new Autor();
        a.setNombre("Mario");
        a.setApellido("Vargas Llosa");
        a.setPais("Perú");
        a.setDireccion("Lima");
        a.setTelefono("555");
        a.setCorreo("mario@gmail.com");

        Autor guardado = autorRepository.save(a);
        autorRepository.delete(guardado);

        Optional<Autor> result = autorRepository.findById(guardado.getIdAutor());

        assertTrue(result.isEmpty());
    }
}
