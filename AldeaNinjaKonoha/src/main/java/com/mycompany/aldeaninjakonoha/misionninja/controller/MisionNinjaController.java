/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldeaninjakonoha.misionninja.controller;

import com.mycompany.aldeaninjakonoha.conexion.ConexionBD;
import com.mycompany.aldeaninjakonoha.conexion.Operaciones;
import com.mycompany.aldeaninjakonoha.mision.model.MisionModel;
import com.mycompany.aldeaninjakonoha.misionninja.model.MisionNinja;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicos
 */
public class MisionNinjaController {

    public MisionNinjaController() {
    }
    
   
    public void save(MisionNinja t) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_mision_ninja( id_ninja, id_mision, fehcaInicio, fechaFinal)VALUES (?,?,?,?);";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stmInsert)) {
            ps.setLong(0, t.getId_ninja());
            ps.setLong(1, t.getId_mision());
            ps.setString(2, t.getFechaInicio().toString());
            ps.setString(3, t.getFechaFin().toString());

            int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
            if (rows <= 0) {
                System.out.println("No se pudo agrear la mision");
            } else {
                System.out.println("Mision creada con exito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MisionNinja getByIdNinja(long misionId) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "select * from tbl_mision where id = ? ;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setLong(1, misionId);
            ResultSet rs = Operaciones.consultar_BD(ps);
            if (rs.next()) {
                MisionNinja misionNinja = new MisionNinja();
                misionNinja.setId_ninja((int) rs.getLong("id_ninja"));
                misionNinja.setId_mision((int) rs.getLong("id_mision"));
                misionNinja.setFechaInicio(LocalDate.parse(rs.getString("fehcaInicio")));
                misionNinja.setFechaFin(LocalDate.parse(rs.getString("fechaFinal")));

                return misionNinja;
            } else {
                System.out.println("ERROR: El id no fue encontrado ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MisionNinja> getAll() {
        List<MisionNinja> lsitMision = new ArrayList<>();
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "SELECT * FROM tbl_mision_ninja";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operaciones.consultar_BD(ps);
            while (rs.next()) {
                MisionNinja misioNinja = new MisionNinja();
                misioNinja.setId_ninja((int) rs.getLong("id_ninja"));
                misioNinja.setId_mision((int) rs.getLong("id_mision"));
                misioNinja.setFechaInicio(LocalDate.parse(rs.getString("fehcaInicio")));
                misioNinja.setFechaFin(LocalDate.parse(rs.getString("fechaFinal")));
                lsitMision.add(misioNinja);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lsitMision;
    }

}
