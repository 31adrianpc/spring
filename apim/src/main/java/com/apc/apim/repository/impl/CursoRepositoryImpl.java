package com.apc.apim.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.apc.apim.entity.CursoEntity;
import com.apc.apim.repository.CursoRepository;

@Repository
public class CursoRepositoryImpl implements CursoRepository{

    @Autowired // Para instanciar el restTemplate que hemos configurado en RestTemplateConfig
    private RestTemplate restTemplate;

    @Value("${url.api}")
    private String URL_API;

    @Override
    public List<CursoEntity> listarCursos() {
        return restTemplate.getForObject(URL_API, List.class);
    }

    @Override
    public CursoEntity obtenerCurso(Integer idCurso) {
        return restTemplate.getForObject(URL_API + "/" + idCurso, CursoEntity.class);
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        return restTemplate.postForObject(URL_API, curso, CursoEntity.class);
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        restTemplate.put(URL_API + "/" + curso.getIdCurso(), curso);
        return obtenerCurso(curso.getIdCurso());
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        CursoEntity curso = obtenerCurso(idCurso);
        restTemplate.delete(URL_API + "/" + idCurso);
        return curso;
    }
    
}
