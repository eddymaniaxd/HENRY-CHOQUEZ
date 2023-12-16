/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Plantilla;

import Datos.DBicicleta;

/**
 *
 * @author step
 */
public class ListarTodo extends DBicicleta{
    
    @Override
    protected void listar() {
         sql = " SELECT *FROM bicicleta";
//         sql = "SELECT b.idBicicleta, b.modelo, b.color, b.estado, t.descripcion FROM bicicleta b, tipo t WHERE b.idTipo=t.idTipo";
    }
}
