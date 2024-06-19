package com.alura.literatura.servicio;

import com.alura.literatura.modelo.Libro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class GutendexServicio {
    private RestTemplate plantillaRest = new RestTemplate();
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
        ResponseEntity<Libro[]> respuesta = plantillaRest.getForEntity(url, Libro[].class);
        return Arrays.asList(respuesta.getBody());
    }
}

//Shakespeare, William
