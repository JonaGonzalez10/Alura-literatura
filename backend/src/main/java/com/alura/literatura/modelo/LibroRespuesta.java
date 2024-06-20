package com.alura.literatura.modelo;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class LibroRespuesta {
    private List<Libro> resultados;
}
