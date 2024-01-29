/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldeaninjakonoha.habilidad.model;

/**
 *
 * @author nicos
 */
public class HabilidadModel {
    private int id_ninja;
    private String nombre;
    private String descripcion;

    public HabilidadModel() {
    }

    public HabilidadModel(int id_ninja, String nombre, String descripcion) {
        this.id_ninja = id_ninja;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_ninja() {
        return id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        this.id_ninja = id_ninja;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HabilidadModel{");
        sb.append("id_ninja=").append(id_ninja);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }
    
    
}
