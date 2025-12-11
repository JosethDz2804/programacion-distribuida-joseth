package com.example.distribuida.Servicelmpl;

import com.example.distribuida.repository.LibroRepository;
import com.example.distribuida.model.Libro;
import com.example.distribuida.Servicelmpl.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository repository;

    @Override
    public List<Libro> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Libro> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Libro save(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public Libro update(Integer id, Libro libro) {
        Libro li = repository.findById(id).orElse(null);
        if (li == null) return null;

        li.setTitulo(libro.getTitulo());
        li.setEditorial(libro.getEditorial());
        li.setNumPaginas(libro.getNumPaginas());
        li.setEdicion(libro.getEdicion());
        li.setIdioma(libro.getIdioma());
        li.setFechaPublicacion(libro.getFechaPublicacion());
        li.setDescripcion(libro.getDescripcion());
        li.setTipoPasta(libro.getTipoPasta());
        li.setIsbn(libro.getIsbn());
        li.setNumEjemplares(libro.getNumEjemplares());
        li.setPortada(libro.getPortada());
        li.setPresentacion(libro.getPresentacion());
        li.setPrecio(libro.getPrecio());
        li.setIdCategoria(libro.getIdCategoria());
        li.setIdAutor(libro.getIdAutor());
        return repository.save(li);
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) repository.deleteById(id);
    }
}