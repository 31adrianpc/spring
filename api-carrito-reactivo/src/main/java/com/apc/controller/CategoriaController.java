package com.apc.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.dto.CategoriaDTO;
import com.apc.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/categorias")
@Tag(name = "API Categoria", description = "Controlador para gestionar categorías")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    @Operation(summary = "Listar todas las categorías", description = "Obtiene una lista de todas las categorías disponibles")
    public Flux<CategoriaDTO> listarCategorias() {
        return categoriaService.listarCategorias()
                               .delayElements(Duration.ofSeconds(3)); // Simula un retraso de 3 segundos no bloqueante 
    }

    @GetMapping("/{idCategoria}")
    @Operation(summary = "Obtener categoría por ID", description = "Obtiene los detalles de una categoría específica por su ID")
    public Mono<CategoriaDTO> obtenerCategoria(@PathVariable Integer idCategoria) {
        return categoriaService.obtenerCategoria(idCategoria)
                               .delayElement(Duration.ofSeconds(3)); // Simula un retraso de 3 segundos no bloqueante
    }
}
