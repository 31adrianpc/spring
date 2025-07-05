package com.apc.entity;

import java.util.Date;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.RepresentationModel;

//import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
@Schema(name = "Curso", description = "Entity de Curso")
@RestResource(exported = false) // No exportamos este recurso dado que ya lo hemos personalizado en CursoController
public class CursoEntity extends RepresentationModel<CursoEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Integer idCurso;

    @Column(name = "nomcurso")
    private String nombreCurso;

    @Column(name = "fechainicio")
    private Date fechaInicio;

    @Column(name = "alumnosmin")
    private Integer alumnosMinimo;

    @Column(name = "alumnosact")
    private Integer alumnosActual;

    @Column(name = "estado")
    private Integer estado;
}
