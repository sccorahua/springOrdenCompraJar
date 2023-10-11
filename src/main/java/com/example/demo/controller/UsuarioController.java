package com.example.demo.controller;

import com.example.demo.dao.entity.UsuarioEntity;
import com.example.demo.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/usuarios/{username}")
    public UsuarioEntity getUser(@PathVariable(value = "username") String usern) {
        return usuarioService.getUser(usern);
    }

    @GetMapping("/usuarios")
    public List<UsuarioEntity> getLista() {
        return usuarioService.getLista();
    }

    @PostMapping("/usuarios")
    public UsuarioEntity insUser(@RequestBody UsuarioEntity user) {
        String password = encoder.encode(user.getContrasena());
        user.setContrasena(password);
        return usuarioService.insUser(user);
    }

    @DeleteMapping("/usuarios/{username}")
    public void delUser(@PathVariable(value = "username") String usern) {
        usuarioService.delUser(usern);
    }
    
    

}
