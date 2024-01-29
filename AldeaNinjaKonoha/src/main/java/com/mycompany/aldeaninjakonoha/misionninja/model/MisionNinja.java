/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldeaninjakonoha.misionninja.model;

import java.time.LocalDate;

/**
 *
 * @author nicos
 */
public class MisionNinja {
    private int id_ninja;
    private int id_mision;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    
  public MisionNinja() {
    }
    
    public MisionNinja(int id_ninja, int id_mision, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id_ninja = id_ninja;
        this.id_mision = id_mision;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFin;
    }

    public int getId_ninja() {
        return id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        this.id_ninja = id_ninja;
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFinal;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFinal = fechaFin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MisionNinja{");
        sb.append("id_ninja=").append(id_ninja);
        sb.append(", id_mision=").append(id_mision);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaFin=").append(fechaFinal);
        sb.append('}');
        return sb.toString();
    }

  
    
}
