package com.apc.cliente_rest.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.apc.cliente_rest.entity.CursoEntity;
import com.apc.cliente_rest.repository.CursoRepository;

@Repository
public class CursoRepositoryImpl implements CursoRepository{
    
    private RestTemplate restTemplate;

    @Value("${url.api.cursos}") // Debe encontrarse en el archivo .properties
    private String URL_API;

    public CursoRepositoryImpl(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<CursoEntity> listarCursos() {
        return restTemplate.getForObject(URL_API, List.class);
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCUrso) {
        return restTemplate.getForObject(URL_API, CursoEntity.class);
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        return restTemplate.postForObject(URL_API, curso, CursoEntity.class);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        restTemplate.put(URL_API + "/" + curso.getIdCurso(), curso);
        curso = obtenerCurso(curso.getIdCurso());
        return curso;
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        CursoEntity curso = obtenerCurso(idCurso);
        restTemplate.delete(URL_API + "/" + idCurso);
        return curso;
    }
    
}
