package com.example.distribuida.Servicelmpl;

import com.example.distribuida.model.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorService {

    List<Autor> findAll();
    Optional<Autor> findById(Integer id);
    Autor save(Autor autor);
    Autor update(Integer id, Autor autor);
    void delete(Integer id);
}
