/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Proxy;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public interface ICliente {
    public int registrar(int idCliente, String nombre,String apellido,String email,String celular,String direccion ) throws Exception;
    public int modificar(int idCliente, String nombre,String apellido,String email,String celular,String direccion) throws Exception;
    public int eliminar(int idCliente) throws Exception;
}
