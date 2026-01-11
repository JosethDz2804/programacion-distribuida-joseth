package com.example.distribuida.controller;

import com.example.distribuida.Servicelmpl.ClienteService;
import com.example.distribuida.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    //BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findOne(@PathVariable int id){
        Optional<Cliente> cliente = clienteService.findById(id);
        if(cliente == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.orElse(null));
    }

    //CREAR
    @PostMapping
    public  ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Cliente clienteNuevo = clienteService.save(cliente);
        return ResponseEntity.ok(clienteNuevo);
    }

    //ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Cliente>update(@PathVariable int id,@RequestBody Cliente cliente){
        Cliente clienteActualizado = clienteService.update(id, cliente);
        if(clienteActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteActualizado);
    }

    //ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
