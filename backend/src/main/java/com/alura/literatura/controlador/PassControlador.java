package com.alura.literatura.controlador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassControlador {
    @Value("${spring.security.user.password}")
    private String contraseña;

    @GetMapping("/getPass")
    public String getPass() {
        return contraseña;
    }
}
