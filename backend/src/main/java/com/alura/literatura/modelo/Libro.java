package com.alura.literatura.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private String idioma;
    private String editorial;
    private String fechaPublicacion;
    private String isbn;
    private String descripcion;
    private String portada;
    private String precio;
    private String cantidadPaginas;
    private String cantidadVendida;
    private String cantidadDisponible;
}
