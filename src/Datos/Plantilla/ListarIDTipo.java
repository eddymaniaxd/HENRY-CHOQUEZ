/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Plantilla;
import Datos.DBicicleta;
/**
 *
 * @author steph
 */
public class ListarIDTipo extends DBicicleta{
    
    @Override
    protected void listar() {
        sql = " SELECT * FROM bicicleta WHERE idTipo=" + this.idTipo;
    }  
    
    
}
