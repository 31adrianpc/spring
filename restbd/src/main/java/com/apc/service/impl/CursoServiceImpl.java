package com.apc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.entity.CursoEntity;
import com.apc.repository.CursoRepository;
import com.apc.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return cursoRepository.findById(idCurso).orElse(null);
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        CursoEntity curso = obtenerCurso(idCurso);
        if (curso != null) {
            curso.setEstado(0);
            cursoRepository.save(curso);
        }
        return curso;
    }
    
}
