package com.example.distribuida.repository;

import com.example.distribuida.model.Cliente;
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
@TestPropertySource(locations = "classpath:application.properties")
public class ClienteRepositoryTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    @Commit
    public void testCrearCliente() {
        Cliente cli = new Cliente();
        cli.setCedula("0102030405");
        cli.setNombre("Juan");
        cli.setApellido("Perez");
        cli.setDireccion("Loja");
        cli.setTelefono("123456789");
        cli.setCorreo("juan@gmail.com");

        Cliente guardado = clienteRepository.save(cli);

        assertNotNull(guardado.getIdCliente());
    }

    @Test
    @Commit
    public void testEditarCliente() {
        Optional<Cliente> op = clienteRepository.findById(49);
        Cliente cli = new Cliente();
        cli.setCedula("1112223334");
        cli.setNombre("Mario");
        cli.setApellido("Lopez");
        cli.setDireccion("Cuenca");
        cli.setTelefono("999");
        cli.setCorreo("mario@gmail.com");

        clienteRepository.save(cli);

        cli.setTelefono("111");
        Cliente actualizado = clienteRepository.save(cli);

        assertEquals("111", actualizado.getTelefono());
    }

    @Test
    @Commit
    public void testBorrarCliente() {
        Cliente cli = new Cliente();
        cli.setCedula("5556667778");
        cli.setNombre("Ana");
        cli.setApellido("Juarez");
        cli.setDireccion("Quito");
        cli.setTelefono("555");
        cli.setCorreo("ana@gmail.com");

        Cliente guardado = clienteRepository.save(cli);
        clienteRepository.delete(guardado);

        Optional<Cliente> resultado = clienteRepository.findById(guardado.getIdCliente());

        assertTrue(resultado.isEmpty());
    }
}
