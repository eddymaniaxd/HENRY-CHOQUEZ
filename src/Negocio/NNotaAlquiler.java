/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DDetalleAlquiler;
import Datos.DNotaAlquiler;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author steph
 */
public class NNotaAlquiler {
    private DNotaAlquiler dnotaalquiler;
    private DDetalleAlquiler ddetallealquiler;
    
    public NNotaAlquiler(){
        dnotaalquiler = new DNotaAlquiler();
        ddetallealquiler = new DDetalleAlquiler();
    }
    
    public int registrar (int idNota, String fecha, String costo, String dias, int idCliente){
        dnotaalquiler.setIdNota(idNota);
        dnotaalquiler.setFecha(fecha);
        dnotaalquiler.setCosto(costo);
        dnotaalquiler.setDias(dias);
        dnotaalquiler.setIdCliente(idCliente);
        return dnotaalquiler.registrar();
    }
    
    public int registrarDetalle (int idNota, int idBicicleta, String observacion){
        ddetallealquiler.setIdNota(idNota);
        ddetallealquiler.setIdBicicleta(idBicicleta);
        ddetallealquiler.setObservacion(observacion);
        return ddetallealquiler.registrar();
    }
    
    public int modificar(int idNota, String fecha, String costo, String dias, int idCliente){
        dnotaalquiler.setIdNota(idNota);
        dnotaalquiler.setFecha(fecha);
        dnotaalquiler.setCosto(costo);
        dnotaalquiler.setDias(dias);
        dnotaalquiler.setIdCliente(idCliente);
        return dnotaalquiler.modificar(idNota);
    }
    
        
    public DefaultTableModel listar(){
        return dnotaalquiler.listar();
    }
    
    public DefaultTableModel listarDetalle(){
        return ddetallealquiler.listar();
    }
}
