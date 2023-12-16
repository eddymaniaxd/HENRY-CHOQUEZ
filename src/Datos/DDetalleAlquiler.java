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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public class DDetalleAlquiler {
   private int idNota;
   private int idBicicleta;
   private String observacion;
   private Conexion conexion;
  
public DDetalleAlquiler(){
    conexion = new Conexion();
}
    public DDetalleAlquiler(int idNota, int idBicicleta, String observacion){
        this.idNota=idNota;
        this.idBicicleta=idBicicleta;
        this.observacion=observacion; 
        conexion = new Conexion();
    } 

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta;
    }
    
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int registrar (){
        int Dstatement = -1;
        if(conexion.abrirConexion()){
            String sql = "INSERT INTO detalleAlquiler(idNota, idBicicleta, observacion) VALUES ('"+idNota+"','"+idBicicleta+"','"+observacion+"');";
            Dstatement = conexion.insert(sql);
            conexion.cerrarConexion();
        }
        return Dstatement;
    }
     
    
    public DefaultTableModel listar(){
        conexion.abrirConexion();
        String [] columnas = {"idNota","idBicicleta","observacion"};
        DefaultTableModel tabla = new DefaultTableModel(columnas, 0);
        Statement statement;
        ResultSet resultset = null;
        String sql = "SELECT d.idNota, d.idBicicleta, d.observacion FROM notaAlquiler n, bicicleta b, detalleAlquiler d WHERE  d.idNota = n.idNota AND d.idBicicleta = b.idBicicleta";        
        try {         
            resultset = conexion.ejecutarSelect(sql);         
            int i = 0;
            while(resultset.next()){
                String[] detalle = new String[3];
                tabla.setRowCount(tabla.getRowCount() + 1);
                tabla.setValueAt(resultset.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultset.getObject(2).toString(), i, 1);
                tabla.setValueAt(resultset.getObject(3).toString(), i, 2);
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

