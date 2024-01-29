/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldeaninjakonoha.mision.model;

/**
 *
 * @author nicos
 */
public class MisionModel {
    private int id;
    private String nombre;
    private String descripcion;
    private String rango;
    private String recompensa;
    private boolean finalizacion;
    
    public MisionModel() {
    }

    public MisionModel(int id, String nombre, String descripcion, String rango, String recompensa, boolean finalizacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;
        this.finalizacion = finalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public boolean isFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(boolean finalizacion) {
        this.finalizacion = finalizacion;
    }
    
        
}
