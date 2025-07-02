package com.apc.cliente_rest.repository;

import java.util.List;

import com.apc.cliente_rest.entity.CursoEntity;

public interface CursoRepository {
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCUrso);
    public CursoEntity registrarCurso(CursoEntity curso);
    public CursoEntity actualizarCurso(CursoEntity curso);
    public CursoEntity eliminarCurso(Integer idCurso);
}
