package com.alura.literatura.repositorio;

import com.alura.literatura.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {
}
