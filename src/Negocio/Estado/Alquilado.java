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
public class Alquilado implements IEstado{
    public Alquilado() {
    }

    
    @Override
    public void Disponible(Estado e) throws Exception {
        e.setMensaje("La Bicicleta no  puede pasar a estar disponible");
        e.setEstadoActual("Disponible");
        throw new Exception("La Bicicleta no  puede pasar a estar disponible");
    }

    @Override
    public void Reservado(Estado e) throws Exception {
        e.setMensaje("La Bicicleta no puede volver a reserva");
        e.setEstadoActual("Reservado");
        throw new Exception("La Bicicleta no puede volver a reserva");        
    }

    @Override
    public void Alquilado(Estado e) throws Exception {
         e.setMensaje("La Bicicleta se encuentra alquilada");
        e.setEstadoActual("Alquilado");
        throw new Exception("La Bicicleta se encuentra alquilada");        
    }

    @Override
    public void Devuelto(Estado e) {
        e.setEstado(new Devuelto());
        e.setMensaje("La Bicicleta paso a ser devuelta");
        e.setEstadoActual("Devuelto");
    }
    
}
