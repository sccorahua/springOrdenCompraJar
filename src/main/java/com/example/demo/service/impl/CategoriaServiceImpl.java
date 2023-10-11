package com.example.demo.service.impl;

import com.example.demo.dao.entity.CategoriaEntity;
import com.example.demo.dao.repositorio.CategoriaRepository;
import com.example.demo.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaEntity findById(int Id) {
        return categoriaRepository.findById(Id);
    }

    @Override
    public void insertar(CategoriaEntity cat) {
        categoriaRepository.save(cat);
    }

    @Override
    public List<CategoriaEntity> obtenerLista() {
        return categoriaRepository.findAll();
    }

    @Override
    public List<CategoriaEntity> obtenerListaOrdenNombre() {
        Sort ascNombre = Sort.by(Sort.Direction.ASC, "nombre");
        return categoriaRepository.findAll(ascNombre);
    }

    @Override
    public List<CategoriaEntity> obtenerLista(Pageable page) {
        return categoriaRepository.findAll(page).getContent();
    }

}
