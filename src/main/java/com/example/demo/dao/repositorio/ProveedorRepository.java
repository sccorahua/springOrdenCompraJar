package com.example.demo.dao.repositorio;

import com.example.demo.dao.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Integer>{
    
}
