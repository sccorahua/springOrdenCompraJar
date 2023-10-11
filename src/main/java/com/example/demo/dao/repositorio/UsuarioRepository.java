package com.example.demo.dao.repositorio;

import com.example.demo.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String>{
}
