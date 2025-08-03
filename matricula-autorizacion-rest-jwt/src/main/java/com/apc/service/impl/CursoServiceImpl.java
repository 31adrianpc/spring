package com.apc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.apc.entity.CursoEntity;
import com.apc.repository.CursoRepository;
import com.apc.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<CursoEntity> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public CursoEntity obtenerCurso(Integer idCurso) {
        return cursoRepository.findById(idCurso).orElse(null);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public CursoEntity registrarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public CursoEntity actualizarCurso(CursoEntity curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') and authentication.name == 'apc2'") // Solo el usuario 'apc2' puede eliminar
    public CursoEntity eliminarCurso(Integer idCurso) {
        CursoEntity curso = obtenerCurso(idCurso);
        if (curso != null) {
            curso.setEstado(0);
            cursoRepository.save(curso);
        }
        return curso;
    }

}
