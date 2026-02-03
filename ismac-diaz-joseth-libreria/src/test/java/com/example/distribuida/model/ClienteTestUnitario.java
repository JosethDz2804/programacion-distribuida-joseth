package com.example.distribuida.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitario {

    @Test
    public void testClienteConstructor() {
        Cliente cliente = new Cliente();
        assertNotNull(cliente); // Verifica que el constructor funciona
    }

    @Test
    public void testIdCliente() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(10);

        assertEquals(10, cliente.getIdCliente());
    }

    @Test
    public void testNombre() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Joseth");

        assertEquals("Joseth", cliente.getNombre());
    }

    @Test
    public void testApellido() {
        Cliente cliente = new Cliente();
        cliente.setApellido("Diaz");

        assertEquals("Diaz", cliente.getApellido());
    }

    @Test
    public void testTelefono() {
        Cliente cliente = new Cliente();
        cliente.setTelefono("0987654321");

        assertEquals("0987654321", cliente.getTelefono());
    }

    @Test
    public void testCorreo() {
        Cliente cliente = new Cliente();
        cliente.setCorreo("correo@example.com");

        assertEquals("correo@example.com", cliente.getCorreo());
    }

    @Test
    public void testSettersAndGettersCompletos() {
        Cliente cliente = new Cliente();

        cliente.setIdCliente(1);
        cliente.setNombre("Ana");
        cliente.setApellido("López");
        cliente.setTelefono("123456789");
        cliente.setCorreo("ana@gmail.com");

        assertEquals(1, cliente.getIdCliente());
        assertEquals("Ana", cliente.getNombre());
        assertEquals("López", cliente.getApellido());
        assertEquals("123456789", cliente.getTelefono());
        assertEquals("ana@gmail.com", cliente.getCorreo());
    }
}
