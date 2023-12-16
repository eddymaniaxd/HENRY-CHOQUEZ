/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DTipo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public class NTipo {
    private DTipo dtipo;
    
    public NTipo(){
        dtipo = new DTipo();
    }
    
    public int registrar (int idTipo, String descripcion){
        dtipo.setIdTipo(idTipo);
        dtipo.setDescripcion(descripcion);
        return dtipo.registrar();
    }
    
    public int modificar(int idTipo, String descripcion){
        dtipo.setIdTipo(idTipo);
        dtipo.setDescripcion(descripcion);
        return dtipo.modificar(idTipo);
    }
    
    public int eliminar(int idTipo){
        dtipo.setIdTipo(idTipo);
        return dtipo.eliminar(idTipo);
    }
    
    public DefaultTableModel listar(){
        return dtipo.listar();
    }
    
    public DefaultComboBoxModel listarCombo(){
        return dtipo.listarCombo();
    }
}
