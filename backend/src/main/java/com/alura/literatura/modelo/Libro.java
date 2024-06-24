package com.alura.literatura.modelo;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<String> subjects;

    @ManyToMany
    @JoinTable(name = "libros_autores",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))

    private List<Persona> authors;

    @ManyToMany
    @JoinTable(name = "libros_traductores",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "traductor_id"))
    private List<Persona> translators;

    @ElementCollection
    private List<String> bookshelves;

    private Boolean copyright;
    private String media_type;

    @ElementCollection
    private Map<String, String> formats;

    private Integer download_count;

    @ElementCollection
    private List<String> languages;
}
