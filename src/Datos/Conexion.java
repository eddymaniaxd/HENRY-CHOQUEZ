/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author steph
 */
public class Conexion {
    public static Connection conexion;
    public static Statement statement;
    
    public static boolean abrirConexion(){
        try {
            Class.forName("org.postgresql.Driver");
//            conexion = DriverManager.getConnection("jdbc:postgresql://miempresa.fun:5432/db_arquitectura_02", "postgres", "0000");
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_arquitectura_02", "postgres", "12345");
//            conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_arquitectura_02", "postgres", "0406");
            statement = conexion.createStatement();
            System.out.println("driver encontrado");
            return true;
        } catch (Exception e) {
            System.out.println("driver no encontrado" + e.getMessage());
            return false;
        }
    }
    
    public static boolean cerrarConexion(){
        try {
            if( conexion != null){
                if( statement != null){
                    statement.close();
                    conexion.close();
                }                
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error al cerrar conexion");
            return false;
        }
    }
    
    public static ResultSet ejecutarSelect(String consultaSql){
        try {
            statement = conexion.createStatement();
            return statement.executeQuery(consultaSql);
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta select" + e.getMessage());
            return null;
        }
    }
    
    public int insert(String sql){
        try {
            return statement.executeUpdate(sql); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"insertar dato",JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    public int update(String sql){
        try {
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Actualizar dato", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    public int delete (String sql){
        try {
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Eliminar dato", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
}
