package com.apc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.dto.ProductoDTO;
import com.apc.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/productos")
@Tag(name = "API Producto", description = "Controlador para gestionar productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Listar productos", description = "Obtiene una lista de todos los productos disponibles")
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
       return ResponseEntity.ok(productoService.listarProductos()); 
    }

    @GetMapping("/{idProducto}")
    @Operation(summary = "Obtener producto por ID", description = "Obtiene los detalles de un producto específico por su ID")
    public ResponseEntity<ProductoDTO> obtenerProducto(@PathVariable Integer idProducto){
        return ResponseEntity.ok(productoService.obtenerProducto(idProducto));
    }
}
