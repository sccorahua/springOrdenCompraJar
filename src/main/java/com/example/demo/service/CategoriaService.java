package com.example.demo.service;

import com.example.demo.dao.entity.CategoriaEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface CategoriaService {

    public CategoriaEntity findById(int Id);

    public void insertar(CategoriaEntity cat);

    public List<CategoriaEntity> obtenerLista();

    public List<CategoriaEntity> obtenerListaOrdenNombre();

    public List<CategoriaEntity> obtenerLista(Pageable page);

}
