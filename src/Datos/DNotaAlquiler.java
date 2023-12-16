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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public class DNotaAlquiler {
   private int idNota;
   private String fecha;
   private String costo;
   private String dias;
   private int idCliente;
   private Conexion conexion;
  
    public DNotaAlquiler(){
      conexion = new Conexion();
    }
    public DNotaAlquiler(int idNota, String fecha, String costo, String dias, int idCliente){
        this.idNota=idNota;
        this.fecha=fecha;
        this.costo=costo;
        this.dias=dias;
        this.idCliente= idCliente;
        conexion = new Conexion();
    } 

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public int registrar (){
        int Dstatement = -1;
        if(conexion.abrirConexion()){
            String sql = "INSERT INTO notaAlquiler(idNota, fecha, costo, dias, idCliente) VALUES ('"+idNota+"','"+fecha+"','"+costo+"','"+dias+"', '"+idCliente+"');";
            Dstatement = conexion.insert(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }
    
    public int modificar (int idNota){
        int Dstatement = -1;
        if(conexion.abrirConexion()){
            String sql = "UPDATE notaAlquiler SET fecha = '"+fecha+"', costo ='"+costo+"',dias = '"+dias+"', idCliente = '"+idCliente+"' WHERE idNota ="+idNota;
            Dstatement = conexion.update(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }
    
    
    public DefaultTableModel listar(){
        conexion.abrirConexion();
        String [] columnas = {"idNota","fecha","costo", "dias", "idCliente"};
        DefaultTableModel tabla = new DefaultTableModel(columnas, 0);
        Statement statement;
        ResultSet resultset = null;
        String sql = "SELECT n.idNota, n.fecha, n.costo, n.dias, c.nombre FROM notaAlquiler n, cliente c WHERE  n.idCliente = c.idCliente";        
        try {         
            resultset = conexion.ejecutarSelect(sql);         
            int i = 0;
            while(resultset.next()){
                String[] nota = new String[5];
                tabla.setRowCount(tabla.getRowCount() + 1);
                tabla.setValueAt(resultset.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultset.getObject(2).toString(), i, 1);
                tabla.setValueAt(resultset.getObject(3).toString(), i, 2);
                tabla.setValueAt(resultset.getObject(4).toString(), i, 3);
                tabla.setValueAt(resultset.getObject(5).toString(), i, 4);
                i++;
            }
            conexion.cerrarConexion();          
        } catch (Exception e) {
            System.out.println("Dato"+e.getMessage());
            System.err.println("no se pudieron cargar los datos"); 
        }
        return tabla;
    }

}
