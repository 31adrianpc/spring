package com.apc.entity;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auditoria")
@Schema(name = "AuditoriaEntity", description = "Entidad que representa la auditoría del sistema")
public class AuditoriaEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "idauditoria")
    private Integer idAuditoria;
    @Column(name = "fechahora")
    private Date fechaHora;
    @Column(name = "idusuario")
    private Integer idUsuario;
    @Column(name = "operacion")
    private String operacion;
}
