/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public abstract class DBicicleta {

    //atributos
    private int idBicicleta;
    private String modelo;
    private String color;
    private String estado;
    protected int idTipo;
    protected String sql;
    private static Conexion conexion;
    private DTipo dtipo;

    //metodos abstractos
    protected abstract void listar();

    //constructores
    public DBicicleta() {
        conexion = new Conexion();
    }

    public DBicicleta(int idBicicleta, String modelo, String color, String estado, int idTipo) {
        this.idBicicleta = idBicicleta;
        this.modelo = modelo;
        this.color = color;
        this.estado = estado;
        this.idTipo = idTipo;
        conexion = new Conexion();
    }

    //metodos 
    public int getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int registrar() {
        int Dstatement = -1;

        if (conexion.abrirConexion()) {
            String sql = "INSERT INTO bicicleta(idBicicleta, modelo, color, estado, idTipo) VALUES ('" + idBicicleta + "','" + modelo + "','" + color + "','" + estado + "', '" + idTipo + "');";
            Dstatement = conexion.insert(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }

    public int modificar(int idBicicleta) {
        int Dstatement = -1;
        if (conexion.abrirConexion()) {
            String sql = "UPDATE bicicleta SET modelo = '" + modelo + "', color ='" + color + "',estado = '" + estado + "', idTipo = '" + idTipo + "' WHERE idBicicleta =" + idBicicleta;
            Dstatement = conexion.update(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }

    public int eliminar(int idBicicleta) {
        int Dstatement = -1;
        if (conexion.abrirConexion()) {
            String sql = "DELETE FROM bicicleta WHERE idBicicleta = " + idBicicleta;
            Dstatement = conexion.delete(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }

    public ArrayList template_method_listar() {
        conexion.abrirConexion();
        ArrayList<Object[]> tabla = new ArrayList<>();
        this.listar();
        Statement statement;
        ResultSet resultset = null;
//        String sql = "SELECT b.idBicicleta, b.modelo, b.color, b.estado, t.descripcion FROM bicicleta b, tipo t WHERE b.idTipo=t.idTipo";
        try {
            resultset = conexion.ejecutarSelect(sql);
            while (resultset.next()) {
                tabla.add(new Object[]{resultset.getInt(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getString(5)});
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Dato" + e.getMessage());
            System.err.println("no se pudieron listar las bicicletas");
        }
        return tabla;
    }

    public String[] getById(int id) throws SQLException {
        String[] registro = null;
        try {
            if (conexion.abrirConexion()) {
                String query = "SELECT * FROM bicicleta WHERE idbicicleta=" + id;
                ResultSet set = null;
                set = conexion.ejecutarSelect(query);
                if (set.next()) {
                    registro = new String[]{
                        String.valueOf(set.getInt("idbicicleta")),
                        set.getString("color"),
                        set.getString("modelo"),
                        set.getString("estado"),
                        String.valueOf(set.getInt("idtipo"))
                    };
                }
                conexion.cerrarConexion();
            }

        } catch (Exception e) {
            System.out.println("error: DBicicleta: getById");
        }
        return registro;

    }

}
