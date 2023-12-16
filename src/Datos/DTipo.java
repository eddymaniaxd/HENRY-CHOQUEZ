/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.beans.Statement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public class DTipo {
   private int idTipo;
   private String descripcion;
   private Conexion conexion;

public DTipo(){
    conexion = new Conexion();
} 

public DTipo(int idTipo, String descripcion){
    this.idTipo= idTipo;
    this.descripcion= descripcion;
    conexion = new Conexion();
} 

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 
    
    public int registrar (){
        int Dstatement = -1;
        if(conexion.abrirConexion()){
            String sql = "INSERT INTO tipo(idTipo,descripcion) VALUES ('"+idTipo+"','"+descripcion+"');";
            Dstatement = conexion.insert(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }
    
    public int modificar (int idTipo){
        int Dstatement = -1;
        if(conexion.abrirConexion()){
            String sql = "UPDATE tipo SET descripcion = '"+descripcion+"' WHERE idTipo ="+idTipo;
            Dstatement = conexion.update(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }
    
    public int eliminar(int idTipo){
        int Dstatement = -1;
        if(conexion.abrirConexion()){
            String sql = "DELETE FROM tipo WHERE idTipo = " + idTipo;
            Dstatement = conexion.delete(sql);
            conexion.cerrarConexion();
        }
        return Dstatement; 
    }
    
    public DefaultTableModel listar(){
        conexion.abrirConexion();
        String [] columnas = {"idTipo","descripcion"};
        DefaultTableModel tabla = new DefaultTableModel(columnas, 0);
        Statement statement;
        ResultSet resultset = null;
        String sql = "SELECT idTipo, descripcion FROM tipo";        
        try {           
            resultset = conexion.ejecutarSelect(sql);
            int i = 0;
            while(resultset.next()){
                String[] tipo = new String[2];
                tabla.setRowCount(tabla.getRowCount() + 1);
                tabla.setValueAt(resultset.getObject(1), i, 0);
                tabla.setValueAt(resultset.getObject(2).toString(), i, 1);
                i++;
            }           
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Dato"+e.getMessage());
            System.err.println("no se pudieron cargar los datos"); 
        }
        return tabla;
    }
    public DefaultComboBoxModel listarCombo(){
        conexion.abrirConexion();
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement statement;
        ResultSet resultset = null;
        String sql = "select idTipo,descripcion from tipo";        
        try {
            resultset = conexion.ejecutarSelect(sql);
            while(resultset.next()){
                combo.addElement(resultset.getObject(1)+" "+resultset.getObject(2));
            }
            resultset.close();
        } catch (Exception e) {
            System.out.println(" no se pudo cargar datos al combo ");
        }
        conexion.cerrarConexion();
        return combo;
    }
}
