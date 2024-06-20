package com.alura.literatura.modelo;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Titulo;

    @ManyToMany
    @JoinTable(name = "libros_autores",
               joinColumns = @JoinColumn(name = "libro_id"),
               inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;

    @ManyToMany
    @JoinTable(name = "libros_idiomas",
               joinColumns = @JoinColumn(name = "libro_id"),
               inverseJoinColumns = @JoinColumn(name = "idioma_id"))
    private List<Idioma> idiomas;
    private Double numeroDeDescargas;
}
