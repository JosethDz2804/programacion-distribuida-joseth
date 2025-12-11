package com.example.distribuida.Servicelmpl;

import com.example.distribuida.repository.ClienteRepository;
import com.example.distribuida.model.Cliente;
import com.example.distribuida.Servicelmpl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        Cliente cli = repository.findById(id).orElse(null);
        if (cli == null) return null;

        cli.setCedula(cliente.getCedula());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
        cli.setDireccion(cliente.getDireccion());
        cli.setTelefono(cliente.getTelefono());
        cli.setCorreo(cliente.getCorreo());

        return repository.save(cli);
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) repository.deleteById(id);
    }
}