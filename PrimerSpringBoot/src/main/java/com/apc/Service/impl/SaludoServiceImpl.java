package com.apc.Service.impl;

import org.springframework.stereotype.Service;

import com.apc.Entity.SaludoEntity;
import com.apc.Service.SaludoService;

@Service
public class SaludoServiceImpl implements SaludoService{

    @Override
    public String saludo(SaludoEntity saludoEntity) {
        return "Hola " + saludoEntity.getNombre() + " de " + saludoEntity.getEdad() + " años";    
    }
    
}
