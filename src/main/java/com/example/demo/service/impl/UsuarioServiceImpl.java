package com.example.demo.service.impl;

import com.example.demo.dao.entity.UsuarioEntity;
import com.example.demo.dao.repositorio.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity getUser(String username) {
        return usuarioRepository.findById(username).get();
    }

    @Override
    public UsuarioEntity insUser(UsuarioEntity user) {
        usuarioRepository.save(user);
        return user;
    }

    @Override
    public List<UsuarioEntity> getLista() {
        return usuarioRepository.findAll();
    }

    @Override
    public void delUser(String username) {
        usuarioRepository.deleteById(username);
    }

}
