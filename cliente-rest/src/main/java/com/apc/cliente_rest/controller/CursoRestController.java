package com.apc.cliente_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.cliente_rest.entity.CursoEntity;
import com.apc.cliente_rest.service.CursoService;

@RestController
@RequestMapping(value = "api/cursos")
public class CursoRestController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoEntity> listarCursos(){
        return cursoService.listarCursos();
    }

    @GetMapping("/{idCurso}")
    public CursoEntity obtenerCurso(@PathVariable Integer idCurso){
        return cursoService.obtenerCurso(idCurso);
    }
}
