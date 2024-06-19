package com.alura.literatura.controlador;


import com.alura.literatura.modelo.Libro;
import com.alura.literatura.servicio.GutendexServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "/libros")
@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class LibroControlador {
    private final GutendexServicio gutendexServicio;
    public LibroControlador(GutendexServicio gutendexServicio) {
        this.gutendexServicio = gutendexServicio;
    }
    @GetMapping("/libros")
    public List<Libro> getLibros(@RequestParam(required = false) String titulo,
                                 @RequestParam(required = false) String autor,
                                 @RequestParam(required = false) String idioma,
                                 @RequestParam(required = false) String genero) {
        return gutendexServicio.getLibros(titulo, autor, idioma, genero);
    }

}
