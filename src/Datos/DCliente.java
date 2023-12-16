/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public class DCliente {
   private int idCliente;
   private String nombre;
   private String apellido;
   private String email;
   private String celular;
   private String direccion;
   private Conexion conexion;
  
public DCliente(){
    conexion = new Conexion();
} 

public DCliente(int idCliente, String nombre, String apellido, String email, String celular, String direccion){
    this.idCliente= idCliente;
    this.nombre= nombre;
    this.apellido= apellido;
    this.email=email;
    this.celular=celular;
    this.direccion=direccion;
    conexion = new Conexion();
} 

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int registrar (){
        int Dstatement = -1;
        
        if(conexion.abrirConexion()){
            String sql = "INSERT INTO cliente(idCliente, nombre, apellido, email, celular, direccion) VALUES ('"+idCliente+"','"+nombre+"','"+apellido+"','"+email+"' ,'"+celular+"','"+direccion+"');";
            Dstatement = conexion.insert(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }
    
    public int modificar (int idCliente){
        int Dstatement = -1;
        if(conexion.abrirConexion()){
            String sql = "UPDATE cliente SET nombre = '"+nombre+"',apellido = '"+apellido+"',email = '"+email+"',celular = '"+celular+"',direccion = '"+direccion+"'  WHERE idCliente ="+idCliente;
            Dstatement = conexion.update(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }
    
    public int eliminar(int idCliente){
        int Dstatement = -1;
        if(conexion.abrirConexion()){
            String sql = "DELETE FROM cliente WHERE idCliente = " + idCliente;
            Dstatement = conexion.delete(sql);
            conexion.cerrarConexion();
        }
        return Dstatement; 
    }
    
    public DefaultTableModel listar(){
        conexion.abrirConexion();
        String [] columnas = {"idCliente","nombre","apellido","email","celular","direccion"};
        DefaultTableModel tabla = new DefaultTableModel(columnas, 0);
        Statement statement;
        ResultSet resultset = null;
        String sql = "SELECT idCliente, nombre, apellido, email, celular, direccion FROM cliente";       
        try {          
            resultset = conexion.ejecutarSelect(sql);          
            int i = 0;
            while(resultset.next()){
                String[] cliente = new String[6];
                tabla.setRowCount(tabla.getRowCount() + 1);
                tabla.setValueAt(resultset.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultset.getObject(2).toString(), i, 1);
                tabla.setValueAt(resultset.getObject(3).toString(), i, 2);
                tabla.setValueAt(resultset.getObject(4).toString(), i, 3);
                tabla.setValueAt(resultset.getObject(5).toString(), i, 4);
                tabla.setValueAt(resultset.getObject(6).toString(), i, 5);
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
        String sql = "select idCliente,nombre from cliente";      
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
