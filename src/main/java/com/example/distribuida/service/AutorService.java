package com.example.distribuida.service;

import com.example.distribuida.model.Autor;
import com.example.distribuida.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor findById(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public void delete(Integer id) {
        autorRepository.deleteById(id);
    }
}
