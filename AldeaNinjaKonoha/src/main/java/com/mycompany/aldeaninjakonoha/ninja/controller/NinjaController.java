/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldeaninjakonoha.ninja.controller;

import com.mycompany.aldeaninjakonoha.conexion.ConexionBD;
import com.mycompany.aldeaninjakonoha.conexion.Operaciones;
import com.mycompany.aldeaninjakonoha.ninja.model.NinjaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicos
 */
public class NinjaController {

    public NinjaController() {
    }

    public void save(NinjaModel t) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_ninja( nombre, rango, aldea)VALUES (?,?,?);";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getRango());
            ps.setString(3, t.getAldea());

            int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
            if (rows <= 0) {
                System.out.println("No se pudo agregar el Ninja");
            } else {
                System.out.println("Ninja agregado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long ninjaId) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "DELETE FROM tbl_ninja WHERE id = ?;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setLong(1, ninjaId);
            int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
            if (rows > 0) {
                System.out.println("Ninja eliminado exitosamente");
                return;
            } else {
                System.out.println("No existe el ninja");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("No se pudo eliminar el Ninja");
        return;
    }

    public void update(NinjaModel t) {

        NinjaModel sqlNinja = getById(t.getId());

        if (sqlNinja != null) {

            sqlNinja.setNombre(t.getNombre());
            sqlNinja.setRango(t.getRango());
            sqlNinja.setAldea(t.getAldea());

            String stmUpdate = """
                    UPDATE tbl_ninja
                    SET
                        nombre = ?,
                        rango = ?,
                        aldea = ?,
                    WHERE id = ?;
                                 """;

            try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stmUpdate)) {
                ps.setString(1, t.getNombre());
                ps.setString(2, t.getRango());
                ps.setString(3, t.getAldea());

                // use Operation class with insert_update_delete and verify if the rows in database are affected
                int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
                if (rows <= 0) {
                    System.out.println("No se pudo actualizar el ninja");
                } else {
                    System.out.println("Ninja actualizado exitosamente");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se encontraron resultados");
        }
    }

    public NinjaModel getById(long ninjaid) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "select * from tbl_ninja where id = ? ;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setLong(1, ninjaid);
            ResultSet rs = Operaciones.consultar_BD(ps);
            if (rs.next()) {
                NinjaModel ninja = new NinjaModel();
                ninja.setId((int) rs.getLong("id"));
                ninja.setNombre(rs.getString("nombre"));
                ninja.setRango(rs.getString("rango"));
                ninja.setAldea(rs.getString("aldea"));
                return ninja;
            } else {
                System.out.println("ERROR: El ide no fue encontrado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NinjaModel> getAll() {
        List<NinjaModel> listNinja = new ArrayList<>();
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "SELECT * FROM tbl_ninja";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operaciones.consultar_BD(ps);
            while (rs.next()) {
                NinjaModel ninja = new NinjaModel();
                ninja.setId((int) rs.getLong("id"));
                ninja.setNombre(rs.getString("nombre"));
                ninja.setRango(rs.getString("rango"));
                ninja.setAldea(rs.getString("aldea"));
                listNinja.add(ninja);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNinja;
    }

}
