package com.apc.apim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.apim.entity.CursoEntity;
import com.apc.apim.service.CursoService;

@RestController
@RequestMapping("/apim/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoEntity> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{idCurso}")
    public CursoEntity obtenerCurso(@PathVariable Integer idCurso) {
        return cursoService.obtenerCurso(idCurso);
    }

    @PostMapping
    public CursoEntity registrarCurso(CursoEntity curso) {
        return cursoService.registrarCurso(curso);
    }

    @PostMapping("/{idCurso}")
    public CursoEntity actualizarCurso(CursoEntity curso, @PathVariable Integer idCurso) {
        curso.setIdCurso(idCurso);
        return cursoService.actualizarCurso(curso);
    }

    @DeleteMapping("/{idCurso}")
    public CursoEntity eliminarCurso(@PathVariable Integer idCurso) {
        return cursoService.eliminarCurso(idCurso);
    }
}
