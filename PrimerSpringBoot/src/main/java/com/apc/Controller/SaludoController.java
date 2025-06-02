package com.apc.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("saludo")
public class SaludoController {
    @GetMapping
    public String saludo() {
        return "Hola Mundo";
    }
    
}
