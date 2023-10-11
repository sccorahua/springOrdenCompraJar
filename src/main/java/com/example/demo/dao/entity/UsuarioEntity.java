package com.example.demo.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "usuario")
@Entity
public class UsuarioEntity {
    @Id
    private String username;
    private String nombres;
    private String apellidos;
    private String contrasena;
}
