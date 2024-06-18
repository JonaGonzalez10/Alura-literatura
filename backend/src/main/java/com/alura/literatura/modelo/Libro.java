package com.alura.literatura.modelo;
import lombok.Data;
@Data
public class Libro {
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
