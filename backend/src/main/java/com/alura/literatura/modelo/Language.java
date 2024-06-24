package com.alura.literatura.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Language {
    @Id
    @GeneratedValue
    private Long id;
    String language;
}
