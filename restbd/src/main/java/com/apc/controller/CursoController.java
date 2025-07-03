package com.apc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.apc.entity.CursoEntity;
//import com.apc.entity.ErrorEntity;
import com.apc.service.CursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "API-Cursos", description = "Controlador para gestionar cursos")
@RequestMapping("api/v1/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    /*
    @ExceptionHandler(ResponseStatusException.class)
    private ResponseStatusException capturadorErrores(ResponseStatusException ex){
        
        En lugar de ResponseStatusException, cuando usabamos Exception y devolviamos un ErrorEntity
        ErrorEntity error = new ErrorEntity();
        String[] datosError = ex.getMessage().replaceAll("\"",";").split(";");
        error.setStatus(datosError[0]);
        error.setMensaje(datosError[1]);
        error.setError(ex.getClass().getName());
        return error;
        
        return ex;
    }
    */

    @GetMapping
    @Operation(summary = "Listar Cursos", description = "Obtiene una lista de todos los cursos disponibles")
    public ResponseEntity<List<CursoEntity>> listarCursos(){
        try {
            List<CursoEntity> cursos = cursoService.listarCursos();
            cursos.forEach(curso -> {
                curso.add(
                    linkTo(
                        methodOn(CursoController.class).obtenerCurso(curso.getIdCurso()) // Se agrega el enlace
                    ).withRel("Ver el detalle del curso " + curso.getNombreCurso()) // Descripción del enlace
                );
            });
            return ResponseEntity.ok(cursos); //Programación modular, utilizando métodos estáticos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{idCurso}")
    @Operation(summary = "Obtener Curso", description = "Obtiene un curso de todos los disponibles a través de su ID")
    public ResponseEntity<CursoEntity> obtenerCurso(@PathVariable Integer idCurso){
        try {
            CursoEntity curso = cursoService.obtenerCurso(idCurso);
            if(curso == null){
                return ResponseEntity.notFound().build();
            }
            return new ResponseEntity<CursoEntity>(cursoService.obtenerCurso(idCurso), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<CursoEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @Operation(summary = "Registrar Curso", description = "Registra un nuevo curso")
    public ResponseEntity<CursoEntity> registrarCurso(@RequestBody CursoEntity curso){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .header("AUTOR", "APC")
                                 .header("FECHA", (new Date()).toString())
                                 .body(cursoService.registrarCurso(curso));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .header("AUTOR", "APC")
                                 .header("FECHA", (new Date()).toString())
                                 .build();
        }
    }

    @PutMapping("/{idCurso}")
    @Operation(summary = "Actualizar Curso", description = "Actualiza un curso a través de su ID")
    public ResponseEntity<CursoEntity> actualizarCurso(@PathVariable Integer idCurso, @RequestBody CursoEntity curso){
        try {
            curso.setIdCurso(idCurso);
            return ResponseEntity.ok(cursoService.actualizarCurso(curso));    
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idCurso}")
    @Operation(summary = "Eliminar Curso", description = "Elimina un curso a través de su ID")
    public ResponseEntity<String> eliminarCurso(@PathVariable Integer idCurso){
        try {
            CursoEntity curso = cursoService.obtenerCurso(idCurso);
            if(curso != null){
                return ResponseEntity.noContent().build();
                //cursoService.eliminarCurso(idCurso);
            }
            else{
                return ResponseEntity.notFound().build();
            }    
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
