package com.apc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.dto.CategoriaDTO;
import com.apc.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/categorias")
@Tag(name = "API Categoria", description = "Controlador para gestionar categorías")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    @Operation(summary = "Listar todas las categorías", description = "Obtiene una lista de todas las categorías disponibles")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{idCategoria}")
    @Operation(summary = "Obtener categoría por ID", description = "Obtiene los detalles de una categoría específica por su ID")
    public ResponseEntity<CategoriaDTO> obtenerCategoria(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok(categoriaService.obtenerCategoria(idCategoria));
    }
}
