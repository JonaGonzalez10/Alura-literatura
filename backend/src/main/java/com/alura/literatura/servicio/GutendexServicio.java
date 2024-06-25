package com.alura.literatura.servicio;

import com.alura.literatura.modelo.Libro;
import com.alura.literatura.modelo.LibroRespuesta;
import com.alura.literatura.repositorio.AutorRepositorio;
import com.alura.literatura.repositorio.IdiomaRepositorio;
import com.alura.literatura.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.alura.literatura.modelo.Persona;
import java.util.List;
@Service
public class GutendexServicio {



    //@Autowired
    //private PersonaRepositorio personaRepositorio;

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Autowired
    private IdiomaRepositorio idiomaRepositorio;
    private RestTemplate plantillaRest = new RestTemplate();

   /* public Autor convertirPersonaAAutor(Persona persona) {

        Persona personaExistente = personaRepositorio.findById(persona.getBirth_year()).orElse(null);
        if (personaExistente == null) {
            // Si la Persona no existe, guardarla en la base de datos
            personaExistente = personaRepositorio.save(persona);
        }
        // Convertir la Persona a Autor
        Autor autor = new Autor();
        autor.setNombre(personaExistente.getName());
        return autor;
    }*/

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
            url += "languages=" + idioma;
            System.out.println("idioma: " + idioma);
        }
        if (genero != null && !genero.isEmpty()) {
            url += "genre=" + genero;
        }
        LibroRespuesta respuesta = plantillaRest.getForObject(url, LibroRespuesta.class);

        if (respuesta == null) {
            System.out.println("No se pudo consultar la API de Gutendex");
            return null;
        }
        List<Libro> libros = respuesta.getResultados();
        if (libros != null) {
           /* for (Libro libro : libros) {
                // Guardar cada autor en la base de datos
                for (Persona autorLibro : libro.getAuthors()) {
                    Autor autorEntidad = new Autor();
                    autorEntidad.setNombre(autorLibro.getName());
                    autorEntidad.setBirthYear(autorLibro.getBirth_year());
                    autorEntidad.setDeathYear(autorLibro.getDeath_year());
                    autorRepositorio.save(autorEntidad);
                }

                // Guardar cada traductor en la base de datos
                for (Persona traductor : libro.getTranslators()) {
                    Autor autorTraductor = new Autor();
                    autorTraductor.setNombre(traductor.getName());
                    autorTraductor.setBirthYear(traductor.getBirth_year());
                    autorTraductor.setDeathYear(traductor.getDeath_year());
                    autorRepositorio.save(autorTraductor);
                }

            */
            System.out.println("si se consulto la API de Gutendex" + respuesta);
            //libroRepositorio.saveAll(libros);
        }
        if (libros == null || libros.isEmpty()) {
            System.out.println("La API de Gutendex no devolvió libros" + respuesta);
            return null;
        }

        return libros;
    }

}

