package com.example.plantalendar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idNotificacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private PerfilUsuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_calendario")
    private CalendarioRiego calendario;

    @Column(name = "tipo_notificacion")
    private String tipoNotificacion;

    @Column(name = "mensaje", nullable = false, columnDefinition = "text")
    private String mensaje;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "leida")
    private Boolean leida;

    public Notificacion() {
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public PerfilUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(PerfilUsuario usuario) {
        this.usuario = usuario;
    }

    public CalendarioRiego getCalendario() {
        return calendario;
    }

    public void setCalendario(CalendarioRiego calendario) {
        this.calendario = calendario;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Boolean getLeida() {
        return leida;
    }

    public void setLeida(Boolean leida) {
        this.leida = leida;
    }
}
