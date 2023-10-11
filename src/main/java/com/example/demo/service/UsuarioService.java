package com.example.demo.service;

import com.example.demo.dao.entity.UsuarioEntity;
import java.util.List;

public interface UsuarioService {
    public UsuarioEntity getUser(String username);
    public UsuarioEntity insUser(UsuarioEntity user);
    public List<UsuarioEntity> getLista();
    public void delUser(String username);
}
