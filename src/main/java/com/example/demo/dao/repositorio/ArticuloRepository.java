package com.example.demo.dao.repositorio;

import com.example.demo.dao.entity.ArticuloEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<ArticuloEntity, Integer>{
}
