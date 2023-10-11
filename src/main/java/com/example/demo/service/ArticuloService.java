package com.example.demo.service;

import com.example.demo.dao.entity.ArticuloEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ArticuloService {
    public void insertar(ArticuloEntity articulo);
    public List<ArticuloEntity> obtenerLista(); 
    public List<ArticuloEntity> obtenerLista(Pageable page); 
}
