package com.alura.literatura.repositorio;
import com.alura.literatura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LibroRepositorio extends JpaRepository<Libro, Long>{

}
