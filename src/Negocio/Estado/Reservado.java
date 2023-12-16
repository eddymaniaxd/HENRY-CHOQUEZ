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
public class Reservado implements IEstado {

    public Reservado() {
    }

    @Override
    public void Disponible(Estado e) {
        e.setEstado(new Disponible());
        e.setMensaje("La Bicicleta paso a estar disponible");
        e.setEstadoActual("Disponible");
    }

    @Override
    public void Reservado(Estado e) throws Exception {
        e.setMensaje("La Bicicleta se encuentra en reserva");
        e.setEstadoActual("Reservado");
       throw new Exception("La Bicicleta se encuentra en reserva");                       
    }

    @Override
    public void Alquilado(Estado e) {
        e.setEstado(new Alquilado());
        e.setMensaje("La bicicleta paso a ser alquilada");
        e.setEstadoActual("Alquilado");
    }

    @Override
    public void Devuelto(Estado e) throws Exception {
        e.setMensaje("La Bicicleta no puede ser devuelto");
        e.setEstadoActual("Reservado");
       throw new Exception("La Bicicleta no puede ser devuelto");                       
    }

}
