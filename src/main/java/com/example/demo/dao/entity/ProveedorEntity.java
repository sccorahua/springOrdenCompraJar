package com.example.demo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedor")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
    @Size(min = 4, max = 50, message = "{javax.validation.constraints.Size.message} 4 y 50!")
    private String nombre;
    @Positive(message = "Debe indicar una tipo de documento!")
    @Column(name = "tipdocumento")
    private String tipDoc;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
    @Size(min = 8, max = 15, message = "{javax.validation.constraints.Size.message} 8 y 15!")
    @Column(name = "numdocumento")
    private String numDoc;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
    @Size(min = 10, max = 50, message = "{javax.validation.constraints.Size.message} 10 y 50!")
    private String direccion;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
    @Size(min = 7, max = 15, message = "{javax.validation.constraints.Size.message} 7 y 15!")
    private String telefono;
    @Email(message = "{javax.validation.constraints.Email.message}")
    @Size(min = 5, max = 30, message = "{javax.validation.constraints.Size.message} 5 y 30!")
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
    private String email;
    private String estado;

}
