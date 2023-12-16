/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Estado;

/**
 *
 * @author steph
 */
public interface IEstado { 
    public void Disponible(Estado e) throws Exception;
    public void Reservado(Estado e) throws Exception;
    public void Alquilado(Estado e) throws Exception;
    public void Devuelto(Estado e) throws Exception;
}
