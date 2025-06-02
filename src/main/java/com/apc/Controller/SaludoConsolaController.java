package com.apc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apc.Entity.SaludoEntity;
import com.apc.Service.SaludoService;

@Component
public class SaludoConsolaController implements CommandLineRunner{

    @Autowired
    private SaludoService saludoService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(saludoService.saludo(new SaludoEntity("Juan", 20)));    
    }
    
}
