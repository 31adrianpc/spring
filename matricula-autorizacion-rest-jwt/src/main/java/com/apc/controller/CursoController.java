package com.apc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.entity.CursoEntity;
import com.apc.service.CursoService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<CursoEntity>> listarCursos() {
        List<CursoEntity> cursos = cursoService.listarCursos();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<CursoEntity> obtenerCurso(@PathVariable("id") Integer idCurso) {
        CursoEntity curso = cursoService.obtenerCurso(idCurso);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CursoEntity> crearCurso(@RequestBody CursoEntity curso) {
        return ResponseEntity.ok(cursoService.registrarCurso(curso));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CursoEntity> actualizarCurso(@PathVariable("id") Integer idCurso, @RequestBody CursoEntity curso) {
        CursoEntity cursoExistente = cursoService.obtenerCurso(idCurso);
        if(cursoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        curso.setIdCurso(idCurso);
        CursoEntity cursoActualizado = cursoService.actualizarCurso(curso);
        return ResponseEntity.ok(cursoActualizado);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') and authentication.name == 'apc2'") // Solo el usuario 'apc2' puede eliminar
    public ResponseEntity<Void> eliminarCurso(@PathVariable("id") Integer idCurso) {
        CursoEntity cursoExistente = cursoService.obtenerCurso(idCurso);
        if(cursoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        cursoService.eliminarCurso(idCurso);
        return ResponseEntity.noContent().build();
    }
}
