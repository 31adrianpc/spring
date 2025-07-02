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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCurso'");
    }

    @Override
    public CursoEntity registrarCurso(CursoEntity curso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarCurso'");
    }

    @Override
    public CursoEntity actualizarCurso(CursoEntity curso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarCurso'");
    }

    @Override
    public CursoEntity eliminarCurso(Integer idCurso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCurso'");
    }
    
}
