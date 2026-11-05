package com.example.plantalendar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "configuracion_invernadero")
public class ConfiguracionInvernadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_configuracion")
    private Integer idConfiguracion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private PerfilUsuario usuario;

    @Column(name = "nombre_sector", nullable = false, length = 100)
    private String nombreSector;

    @Column(name = "humedad_optima_pct", precision = 5, scale = 2)
    private BigDecimal humedadOptimaPct;

    @Column(name = "temp_min_noche_c", precision = 5, scale = 2)
    private BigDecimal tempMinNocheC;

    @Column(name = "temp_max_dia_c", precision = 5, scale = 2)
    private BigDecimal tempMaxDiaC;

    @Column(name = "frecuencia_registro_min")
    private Integer frecuenciaRegistroMin;

    public ConfiguracionInvernadero() {
    }

    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public PerfilUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(PerfilUsuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public BigDecimal getHumedadOptimaPct() {
        return humedadOptimaPct;
    }

    public void setHumedadOptimaPct(BigDecimal humedadOptimaPct) {
        this.humedadOptimaPct = humedadOptimaPct;
    }

    public BigDecimal getTempMinNocheC() {
        return tempMinNocheC;
    }

    public void setTempMinNocheC(BigDecimal tempMinNocheC) {
        this.tempMinNocheC = tempMinNocheC;
    }

    public BigDecimal getTempMaxDiaC() {
        return tempMaxDiaC;
    }

    public void setTempMaxDiaC(BigDecimal tempMaxDiaC) {
        this.tempMaxDiaC = tempMaxDiaC;
    }

    public Integer getFrecuenciaRegistroMin() {
        return frecuenciaRegistroMin;
    }

    public void setFrecuenciaRegistroMin(Integer frecuenciaRegistroMin) {
        this.frecuenciaRegistroMin = frecuenciaRegistroMin;
    }
}
