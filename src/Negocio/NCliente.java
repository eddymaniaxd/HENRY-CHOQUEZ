/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DCliente;
import Negocio.Proxy.ICliente;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 *  */
public class NCliente implements ICliente{
    private DCliente dcliente;
    
    public NCliente(){
        dcliente = new DCliente();
    }
    
    @Override
    public int registrar (int idCliente, String nombre, String apellido, String email, String celular, String direccion){
        dcliente.setIdCliente(idCliente);
        dcliente.setNombre(nombre);
        dcliente.setApellido(apellido);
        dcliente.setEmail(email);
        dcliente.setCelular(celular);
        dcliente.setDireccion(direccion);
        
        return dcliente.registrar();
    }
    
    @Override
    public int modificar(int idCliente, String nombre, String apellido, String email, String celular, String direccion){
        dcliente.setIdCliente(idCliente);
        dcliente.setNombre(nombre);
        dcliente.setApellido(apellido);
        dcliente.setEmail(email);
        dcliente.setCelular(celular);
        dcliente.setDireccion(direccion);
        
        return dcliente.modificar(idCliente);
    }
    
    @Override
    public int eliminar(int idCliente){
        dcliente.setIdCliente(idCliente);
        
        return dcliente.eliminar(idCliente);
    }
    
    public DefaultTableModel listar(){
        return dcliente.listar();
    }
    
    public DefaultComboBoxModel listarCombo(){
        return dcliente.listarCombo();
    }
}
