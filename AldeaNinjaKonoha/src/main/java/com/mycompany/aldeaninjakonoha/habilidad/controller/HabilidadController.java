/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldeaninjakonoha.habilidad.controller;

import com.mycompany.aldeaninjakonoha.conexion.ConexionBD;
import com.mycompany.aldeaninjakonoha.conexion.Operaciones;
import com.mycompany.aldeaninjakonoha.habilidad.model.HabilidadModel;
import com.mycompany.aldeaninjakonoha.mision.model.MisionModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicos
 */
public class HabilidadController {

    public HabilidadController() {
    }
    
    public void save(HabilidadModel t) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_habilidad( id_ninja, nombre, descripcion,)VALUES (?,?,?);";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stmInsert)) {
            ps.setInt(1, t.getId_ninja());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getDescripcion());

            int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
            if (rows <= 0) {
                System.out.println("No se pudo crear la habilidad");
            } else {
                System.out.println("Habilidad creada con exito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String nombre) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "DELETE FROM tbl_habilidad WHERE nombre = ?;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setString(1, nombre);
            int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
            if (rows > 0) {
                System.out.println("Habilidad eliminada con exito");
                return;
            } else {
                System.out.println("No existe la habilidad");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("No se pudo eliminar al habilidad");
        return;
    }
  
}
