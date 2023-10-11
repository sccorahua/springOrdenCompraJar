package com.example.demo.dao.repositorio;

import com.example.demo.dao.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

    public CategoriaEntity findById(int Id);
}
