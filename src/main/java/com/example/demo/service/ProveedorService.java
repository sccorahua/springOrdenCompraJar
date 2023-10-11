package com.example.demo.service;

import com.example.demo.dao.entity.ProveedorEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ProveedorService {

    public void insertar(ProveedorEntity prov);

    public List<ProveedorEntity> getLista();

    public List<ProveedorEntity> getLista(Pageable page);
    
    public List<ProveedorEntity> getListaByNombre();
}
