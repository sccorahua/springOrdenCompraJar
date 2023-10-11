package com.example.demo.service.impl;

import com.example.demo.dao.entity.ArticuloEntity;
import com.example.demo.dao.repositorio.ArticuloRepository;
import com.example.demo.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public void insertar(ArticuloEntity articulo) {
        articuloRepository.save(articulo);
    }

    @Override
    public List<ArticuloEntity> obtenerLista() {
        return articuloRepository.findAll();
    }

    @Override
    public List<ArticuloEntity> obtenerLista(Pageable page) {
        return articuloRepository.findAll(page).getContent();
    }

}
