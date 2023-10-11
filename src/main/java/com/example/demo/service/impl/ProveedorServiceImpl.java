package com.example.demo.service.impl;

import com.example.demo.dao.entity.ProveedorEntity;
import com.example.demo.dao.repositorio.ProveedorRepository;
import com.example.demo.service.ProveedorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public void insertar(ProveedorEntity prov) {
        proveedorRepository.save(prov);
    }

    @Override
    public List<ProveedorEntity> getLista() {
        return proveedorRepository.findAll();
    }

    @Override
    public List<ProveedorEntity> getLista(Pageable page) {
        return proveedorRepository.findAll(page).getContent();
    }

    @Override
    public List<ProveedorEntity> getListaByNombre() {
        Sort ascNombre = Sort.by(Sort.Direction.ASC, "nombre");
        return proveedorRepository.findAll(ascNombre);
    }

}
