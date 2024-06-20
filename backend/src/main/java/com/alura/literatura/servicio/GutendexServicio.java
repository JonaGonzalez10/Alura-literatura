package com.alura.literatura.servicio;

import com.alura.literatura.modelo.Libro;
import com.alura.literatura.modelo.LibroRespuesta;
import com.alura.literatura.repositorio.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Service
public class GutendexServicio {
    private RestTemplate plantillaRest = new RestTemplate();
    private final LibroRepositorio libroRepositorio;

    public GutendexServicio(LibroRepositorio libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    public List<Libro> getLibros(String titulo, String autor, String idioma, String genero) {
        String url = "https://gutendex.com/books?";
        if (titulo != null && !titulo.isEmpty()) {
            url += "title=" + titulo + "&";
        }
        if (autor != null && !autor.isEmpty()) {
            url += "author=" + autor + "&";
        }
        if (idioma != null && !idioma.isEmpty()) {
            url += "languages=" + idioma + "&";
        }
        if (genero != null && !genero.isEmpty()) {
            url += "genre=" + genero;
        }
        LibroRespuesta respuesta = plantillaRest.getForObject(url, LibroRespuesta.class);
        List<Libro> libros = respuesta.getResultados();
        if (libros != null) {
            libroRepositorio.saveAll(libros);
        }

        return libros;
    }
}

