package com.alura.literatura.controlador;


import com.alura.literatura.modelo.Libro;
import com.alura.literatura.servicio.GutendexServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping
@CrossOrigin(origins = "*")
@RestController
public class LibroControlador {
    private final GutendexServicio gutendexServicio;
    public LibroControlador(GutendexServicio gutendexServicio) {
        this.gutendexServicio = gutendexServicio;
    }
    @GetMapping("/libros")
    public List<Libro> getLibros(@RequestParam(required = false) String title,
                                 @RequestParam(required = false) String author,
                                 @RequestParam(required = false) String languaje,
                                 @RequestParam(required = false) String genre)
    {
        return gutendexServicio.getLibros(title, author, languaje, genre);
    }

}
