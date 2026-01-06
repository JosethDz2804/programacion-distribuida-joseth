package com.example.distribuida.Servicelmpl;

import com.example.distribuida.repository.CategoriaRepository;
import com.example.distribuida.model.Categoria;
import com.example.distribuida.Servicelmpl.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria update(Integer id, Categoria categoria) {
        Categoria cat = repository.findById(id).orElse(null);
        if (cat == null) return null;

        cat.setCategoria(categoria.getCategoria());
        cat.setDescripcion(categoria.getDescripcion());

        return repository.save(cat);
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) repository.deleteById(id);
    }
}
