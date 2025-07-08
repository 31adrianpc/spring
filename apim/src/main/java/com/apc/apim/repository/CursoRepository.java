package com.apc.apim.repository;

import java.util.List;

import com.apc.apim.entity.CursoEntity;

public interface CursoRepository {
    public List<CursoEntity> listarCursos();
    public CursoEntity obtenerCurso(Integer idCurso);
    public CursoEntity registrarCurso(CursoEntity curso);
    public CursoEntity actualizarCurso(CursoEntity curso);
    public CursoEntity eliminarCurso(Integer idCurso);
}
