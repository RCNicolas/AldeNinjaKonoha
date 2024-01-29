/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldeaninjakonoha.mision.controller;

import com.mycompany.aldeaninjakonoha.conexion.ConexionBD;
import com.mycompany.aldeaninjakonoha.conexion.Operaciones;
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
public class MisionController {

    public MisionController() {
    }

    public void save(MisionModel t) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_mision( nombre, descripcion, rango, recompensa, finalizada)VALUES (?,?,?,?,?);";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDescripcion());
            ps.setString(3, t.getRango());
            ps.setString(4, t.getRecompensa());
            ps.setBoolean(5, t.isFinalizacion());

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

    public void delete(long misionId) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "DELETE FROM tbl_mision WHERE id = ?;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setLong(1, misionId);
            int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
            if (rows > 0) {
                System.out.println("Mision aliminada con exito");
                return;
            } else {
                System.out.println("No existe la mision");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("No se pudo eliminar la Mision");
        return;
    }

    public void update(MisionModel t) {

        MisionModel sqlMision = getById(t.getId());

        if (sqlMision != null) {

            sqlMision.setNombre(t.getNombre());
            sqlMision.setDescripcion(t.getDescripcion());
            sqlMision.setRango(t.getRango());
            sqlMision.setRecompensa(t.getRecompensa());
            sqlMision.setFinalizacion(t.isFinalizacion());

            String stmUpdate = """
                    UPDATE tbl_mision
                    SET
                        nombre = ?,
                        descripcion = ?,
                        rango = ?,
                        recompensa = ?,
                        finalizada = ?,
                    WHERE id = ?;
                                 """;

            try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stmUpdate)) {
                ps.setString(1, t.getNombre());
                ps.setString(2, t.getDescripcion());
                ps.setString(2, t.getRango());
                ps.setString(3, t.getRecompensa());
                ps.setBoolean(4, t.isFinalizacion());

                // use Operation class with insert_update_delete and verify if the rows in database are affected
                int rows = Operaciones.insertar_actualizar_borrar_BD(ps);
                if (rows <= 0) {
                    System.out.println("No se pudo actualiza la mision");
                } else {
                    System.out.println("Mision actualizada con exito");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se encontraron resultados");
        }
    }

    public MisionModel getById(long misionId) {
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "select * from tbl_mision where id = ? ;";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ps.setLong(1, misionId);
            ResultSet rs = Operaciones.consultar_BD(ps);
            if (rs.next()) {
                MisionModel mision = new MisionModel();
                mision.setId((int) rs.getLong("id"));
                mision.setNombre(rs.getString("nombre"));
                mision.setDescripcion(rs.getString("descripcion"));
                mision.setRango(rs.getString("rango"));
                mision.setRecompensa(rs.getString("recompensa"));
                mision.setFinalizacion(rs.getBoolean("finalizada"));

                return mision;
            } else {
                System.out.println("ERROR: El id no fue encontrado ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MisionModel> getAll() {
        List<MisionModel> lsitMision = new ArrayList<>();
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "SELECT * FROM tbl_mision";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operaciones.consultar_BD(ps);
            while (rs.next()) {
                MisionModel mision = new MisionModel();
                mision.setId((int) rs.getLong("id"));
                mision.setNombre(rs.getString("nombre"));
                mision.setDescripcion(rs.getString("descripcion"));
                mision.setRango(rs.getString("rango"));
                mision.setRecompensa(rs.getString("recompensa"));
                mision.setFinalizacion(rs.getBoolean("finalizada"));
                lsitMision.add(mision);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lsitMision;
    }

      public List<MisionModel> obtenerMisionesCompletadas() {
        List<MisionModel> lsitMision = new ArrayList<>();
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String stm = "SELECT * FROM tbl_mision where finalizada = true";

        try (PreparedStatement ps = Operaciones.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operaciones.consultar_BD(ps);
            while (rs.next()) {
                MisionModel mision = new MisionModel();
                mision.setId((int) rs.getLong("id"));
                mision.setNombre(rs.getString("nombre"));
                mision.setDescripcion(rs.getString("descripcion"));
                mision.setRango(rs.getString("rango"));
                mision.setRecompensa(rs.getString("recompensa"));
                mision.setFinalizacion(rs.getBoolean("finalizada"));
                lsitMision.add(mision);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lsitMision;
    }

}
