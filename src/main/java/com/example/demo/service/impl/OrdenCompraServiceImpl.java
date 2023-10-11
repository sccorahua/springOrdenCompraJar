/*
package com.example.demo.service.impl;

import com.example.demo.dao.entity.OrdenCompraEntity;
import com.example.demo.dao.repositorio.OrdenCompraRepository;
import com.example.demo.service.OrdenCompraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Override
    public void insertar(OrdenCompraEntity orden) {
        ordenCompraRepository.save(orden);
    }

    @Override
    public List<OrdenCompraEntity> getLista() {
        return ordenCompraRepository.findAll();
    }

    @Override
    public List<OrdenCompraEntity> getLista(Pageable page) {
        return ordenCompraRepository.findAll(page).getContent();
    }

}
*/