package com.alura.literatura.modelo;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class LibroRespuesta {
    private Integer count;
    private String next;
    private String previous;
    private List<Libro> results;

    public List<Libro> getResultados() {
        return results;
    }
}
