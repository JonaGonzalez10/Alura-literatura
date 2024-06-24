package com.alura.literatura.modelo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public void setBirthYear(Integer birthYear) {
    }

    public void setDeathYear(Integer deathYear) {
    }
}
