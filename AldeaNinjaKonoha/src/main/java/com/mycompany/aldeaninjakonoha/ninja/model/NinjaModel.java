/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldeaninjakonoha.ninja.model;


import com.mycompany.aldeaninjakonoha.ninja.controller.NinjaController;
import java.util.List;

/**
 * @author nicos
 */
public class NinjaModel {

    private int opcion = 0;

    private int id;
    private String nombre;
    private String rango;
    private String aldea;
   

    public NinjaModel() {
    }

    public NinjaModel(String nombre, String rango, String aldea) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
    }

    public void imprimirNinja() {
        NinjaController ninja = new NinjaController();
        
        List<NinjaModel> lista = ninja.getAll();
        System.out.println(lista.toString());
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
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

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NinjaModel{");
        sb.append("opcion=").append(opcion);
        sb.append(", id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", rango=").append(rango);
        sb.append(", aldea=").append(aldea);
        sb.append('}');
        return sb.toString();
    }

}
