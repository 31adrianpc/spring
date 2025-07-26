package com.apc.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.apc.entity.CursoEntity;

import lombok.extern.java.Log;

@Component
@Log
public class CursoController {
    
    @KafkaListener(topics = "${kafka.topic}")
    public void listen(CursoEntity curso){
        log.info("El mensaje recibido es: " + curso);
    }
}
