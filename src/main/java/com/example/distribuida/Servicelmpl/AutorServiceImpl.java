package com.example.distribuida.Servicelmpl;

import com.example.distribuida.repository.AutorRepository;
import com.example.distribuida.model.Autor;
import com.example.distribuida.Servicelmpl.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository repository;

    @Override
    public List<Autor> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Autor> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Autor save(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public Autor update(Integer id, Autor autor) {
        Autor au = repository.findById(id).orElse(null);
        if (au == null) return null;

        au.setNombre(autor.getNombre());
        au.setApellido(autor.getApellido());
        au.setPais(autor.getPais());
        au.setDireccion(autor.getDireccion());
        au.setTelefono(autor.getTelefono());
        au.setCorreo(autor.getCorreo());

        return repository.save(au);
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) repository.deleteById(id);
    }
}