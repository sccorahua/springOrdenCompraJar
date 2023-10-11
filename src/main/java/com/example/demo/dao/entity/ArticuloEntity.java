package com.example.demo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")
public class ArticuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
    @Size(min = 4, max = 50, message = "{javax.validation.constraints.Size.message} 4 y 50!")
    private String nombre;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
    @Size(min = 3, max = 100, message = "{javax.validation.constraints.Size.message} 3 y 100!")
    private String descripcion;
    @Column(name = "id_categoria", nullable = false)
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @Positive(message = "Debe indicar una categoria!")
    private int categoria;
}
