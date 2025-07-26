package com.apc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.entity.CursoEntity;

@RestController
public class CursoController {
    
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    @RequestMapping("/curso/send/{idCurso}")
    public String enviarCurso(@PathVariable Integer idCurso){
        CursoEntity curso = new CursoEntity(idCurso, "Curso de spring boot", new Date(), 5, 30, 1);
        kafkaTemplate.send(topic, curso);
        return "Mensaje enviado: " + curso.toString();
    }
}
