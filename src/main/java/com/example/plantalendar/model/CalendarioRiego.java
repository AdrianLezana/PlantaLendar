package com.example.plantalendar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "calendario_riego")
public class CalendarioRiego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendario")
    private Integer idCalendario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private PerfilUsuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    private ConfiguracionInvernadero configuracion;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "dias_semana", nullable = false, columnDefinition = "text[]")
    private List<String> diasSemana;

    @Column(name = "hora_riego", nullable = false)
    private LocalTime horaRiego;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos = 15;

    @Column(name = "activo")
    private Boolean activo = true;

    public CalendarioRiego() {
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public PerfilUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(PerfilUsuario usuario) {
        this.usuario = usuario;
    }

    public ConfiguracionInvernadero getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionInvernadero configuracion) {
        this.configuracion = configuracion;
    }

    public List<String> getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(List<String> diasSemana) {
        this.diasSemana = diasSemana;
    }

    public LocalTime getHoraRiego() {
        return horaRiego;
    }

    public void setHoraRiego(LocalTime horaRiego) {
        this.horaRiego = horaRiego;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
