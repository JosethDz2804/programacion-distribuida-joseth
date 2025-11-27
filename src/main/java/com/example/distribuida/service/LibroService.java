package com.example.distribuida.service;

import com.example.distribuida.model.Libro;
import com.example.distribuida.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Libro findById(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public void delete(Integer id) {
        libroRepository.deleteById(id);
    }
}
