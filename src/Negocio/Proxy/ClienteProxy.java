/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Proxy;

import Negocio.NCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public class ClienteProxy implements ICliente{
    private NCliente clienteVerificado;
    

    @Override
    public int registrar(int idCliente, String nombre, String apellido, String email, String celular, String direccion) throws Exception {
        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; 
        Pattern pattern = Pattern.compile(regx);  
         Matcher matcher = pattern.matcher(email);    
         if(matcher.matches()){
             if(clienteVerificado == null){
                 clienteVerificado = new NCliente();
             }
             return clienteVerificado.registrar(idCliente, nombre, apellido, email, celular, direccion);
         }else{
            throw new Exception("Formato de email no valido");
 
//             JOptionPane.showMessageDialog(null, "Formato de email no valido", "Registrar", JOptionPane.INFORMATION_MESSAGE);
             //System.out.println("Formato de email no valido");
         }
//         return -1;
    }

    @Override
    public int modificar(int idCliente, String nombre, String apellido, String email, String celular, String direccion) throws Exception {
        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; 
        Pattern pattern = Pattern.compile(regx);  
         Matcher matcher = pattern.matcher(email);         
         if(matcher.matches()){
             if(clienteVerificado == null){
                 clienteVerificado = new NCliente();
                return clienteVerificado.modificar(idCliente,nombre, apellido, email, celular, direccion);
             }else{
                return clienteVerificado.modificar(idCliente,nombre, apellido, email, celular, direccion);
             }  
         }else{
            throw new Exception("Formato de email no valido");             
//         JOptionPane.showMessageDialog(null, "Formato de email no valido", "Modificar", JOptionPane.INFORMATION_MESSAGE);
        }
//        return -1;
    }

    @Override
    public int eliminar(int idCliente) { 
        clienteVerificado = new NCliente();
        return clienteVerificado.eliminar(idCliente);
    }

}
