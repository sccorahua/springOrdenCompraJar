package com.example.demo;

import com.example.demo.dao.entity.UsuarioEntity;
import com.example.demo.dao.repositorio.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class OrdenCompraApplicationTests {
/*
    @Autowired
    private UsuarioRepository urepo;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @Test
    void insertarUsuario() {
        UsuarioEntity ue = new UsuarioEntity();
        ue.setUsername("1");
        ue.setNombres("1");
        ue.setApellidos("1");
        ue.setContrasena(encoder.encode("1"));
        UsuarioEntity a = urepo.save(ue);
        Assertions.assertNotNull(a);
    }
    */
}
