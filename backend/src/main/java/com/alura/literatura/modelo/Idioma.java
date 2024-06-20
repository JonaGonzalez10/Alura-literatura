package com.alura.literatura.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "idiomas")
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String idioma;
}
