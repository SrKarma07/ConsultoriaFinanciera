
package com.example.consultoriafinanciera.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "suscripcion")
public class Suscripcion {

    @Id
    private String numeroSuscripcion;

    private String tipoSuscripcion;
    private int cantidadAsesorias;
    private int saldoAsesorias;
    private LocalDate fechaCaducidad;
    private String estado;

    // Getters y Setters


    public String getNumeroSuscripcion() {
        return numeroSuscripcion;
    }

    public void setNumeroSuscripcion(String numeroSuscripcion) {
        this.numeroSuscripcion = numeroSuscripcion;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public int getCantidadAsesorias() {
        return cantidadAsesorias;
    }

    public void setCantidadAsesorias(int cantidadAsesorias) {
        this.cantidadAsesorias = cantidadAsesorias;
    }

    public int getSaldoAsesorias() {
        return saldoAsesorias;
    }

    public void setSaldoAsesorias(int saldoAsesorias) {
        this.saldoAsesorias = saldoAsesorias;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
