/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DBicicleta;
import Datos.Plantilla.ListarIDTipo;
import Datos.Plantilla.ListarTodo;
import Negocio.Estado.Estado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author steph
 */
public class NBicicleta {    
    private DBicicleta dListarTipo;
    private DBicicleta dbicicleta;    
    private Estado estado;
    
    public NBicicleta(){
        dListarTipo = new ListarIDTipo();
        dbicicleta = new ListarTodo();        
//        dListarTodo = new ListarTodo();        
//        dbicicleta = dListarTipo;
        
        this.estado = new Estado();
    }
    
    public int registrar (int idBicicleta, String modelo, String color, String estado, int idTipo) throws Exception{
        if (! Estado.disponible.equals(estado)) {
          throw new Exception("Inicie con el estado Disponible");
        }
        dbicicleta.setIdBicicleta(idBicicleta);
        dbicicleta.setModelo(modelo);
        dbicicleta.setColor(color);
        dbicicleta.setEstado(estado);
        dbicicleta.setIdTipo(idTipo);
        return dbicicleta.registrar( );
    }
    
    public int modificar(int idBicicleta,String modelo, String color,String estado, int idTipo) throws Exception{
        String[] res = dbicicleta.getById(idBicicleta);
        String resEst = res[3];
        this.estado.updateEstado(resEst);
        this.estado.nextEstado(estado);   
        //actualizar
        dbicicleta.setIdBicicleta(idBicicleta);
        dbicicleta.setModelo(modelo);
        dbicicleta.setColor(color);
        dbicicleta.setEstado(estado);
        dbicicleta.setIdTipo(idTipo);
        return dbicicleta.modificar(idBicicleta);
    }
    
    
    public int eliminar(int idBicicleta){
        dbicicleta.setIdBicicleta(idBicicleta);
        return dbicicleta.eliminar(idBicicleta);
    }
     
    public ArrayList Listar(int idTipo) throws SQLException{
//           dbicicleta.setIdTipo(idTipo);
        dListarTipo.setIdTipo(idTipo);
//        dbicicleta = this.dListarTipo;
        return dListarTipo.template_method_listar();
    }
    
    public ArrayList ListarTodos() throws SQLException{
//            dbicicleta = new ListarTodo();
//        dbicicleta = this.dListarTodo;
        return dbicicleta.template_method_listar();
    }
    
    
    
    
    
    
    
    
//    switch (resEst) {
//            case "Disponible":
//                this.estado.setDisponible();                 
//            break;
//            case "Reservado":
//                this.estado.setReservado();
//            break;
//            case "Alquilado":
//                this.estado.setAlquilado();
//            break;
//            case "Devuelto":
//                this.estado.setAlquilado();
//            break;            
//            default:
//                throw new Exception("Error NBicicleta modificar: no se encontro estado");
//        }
}
