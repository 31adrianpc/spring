package com.apc.cliente_rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apc.cliente_rest.entity.CursoEntity;
import com.apc.cliente_rest.repository.CursoRepository;
import com.apc.cliente_rest.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoEntity> listarCursos() {
        return cursoRepository.listarCursos();
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCUrso) {
        return cursoRepository.obtenerCurso(idCUrso);
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        return cursoRepository.registrarCurso(curso);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        return cursoRepository.actualizarCurso(curso);
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        return cursoRepository.eliminarCurso(idCurso);
    }
    
}
