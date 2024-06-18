package com.alura.literatura.servicio;

import com.alura.literatura.modelo.Libro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class GutendexServicio {
    private RestTemplate plantillaRest = new RestTemplate();
    public List<Libro> getLibros() {
        String url = "https://gutendex.com/books";
        ResponseEntity<Libro[]> respuesta = plantillaRest.getForEntity(url, Libro[].class);
        return Arrays.asList(respuesta.getBody());
    }
}
